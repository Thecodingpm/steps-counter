package com.abbusteps.app.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import com.abbusteps.app.AbbuStepsApplication
import com.abbusteps.app.MainActivity
import com.abbusteps.app.R
import com.abbusteps.app.data.repository.StepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Foreground service for step counting.
 * Uses TYPE_STEP_DETECTOR with rate limiting and debouncing.
 */
class StepCounterService : LifecycleService(), SensorEventListener {
    
    companion object {
        private const val TAG = "StepCounterService"
        private const val CHANNEL_ID = "step_counter_channel"
        private const val NOTIFICATION_ID = 1001
        
        // Rate limiting: minimum time between step counts (prevents shake detection)
        private const val MIN_STEP_INTERVAL_MS = 300L // At least 300ms between steps
        private const val MAX_STEPS_PER_SECOND = 3 // Max 3 steps per second (fast running)
    }
    
    inner class LocalBinder : Binder() {
        fun getService(): StepCounterService = this@StepCounterService
    }
    
    private val binder = LocalBinder()
    
    private lateinit var repository: StepRepository
    private var sensorManager: SensorManager? = null
    private var stepDetectorSensor: Sensor? = null
    
    // Step counting state
    private var currentStepCount = 0
    private var isInitialized = false
    private var isPaused = false
    
    // Rate limiting
    private var lastStepTime = 0L
    private var stepsInCurrentSecond = 0
    private var currentSecond = 0L
    
    // Listeners
    var onStepUpdateListener: ((Int) -> Unit)? = null
    var onPauseStateListener: ((Boolean) -> Unit)? = null
    
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Service created")
        
        repository = (application as AbbuStepsApplication).repository
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        
        // Use STEP_DETECTOR - it detects each individual step
        stepDetectorSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
        
        if (stepDetectorSensor == null) {
            Log.w(TAG, "Step detector sensor not available")
        }
        
        createNotificationChannel()
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Log.d(TAG, "Service onStartCommand")
        
        // Start foreground service
        startForeground(NOTIFICATION_ID, createNotification())
        
        // Initialize step counting
        lifecycleScope.launch {
            initializeStepCounting()
            loadPauseState()
            startSensorListening()
        }
        
        return START_STICKY
    }
    
    override fun onBind(intent: Intent): IBinder {
        super.onBind(intent)
        return binder
    }
    
    /**
     * Initialize step counting from saved state.
     */
    private suspend fun initializeStepCounting() {
        withContext(Dispatchers.IO) {
            try {
                // Get today's steps from database
                val todayRecord = repository.getTodayStepRecord().first()
                currentStepCount = todayRecord?.steps ?: 0
                
                Log.d(TAG, "Initialized with today's steps: $currentStepCount")
                
                isInitialized = true
                
                // Notify listener
                withContext(Dispatchers.Main) {
                    onStepUpdateListener?.invoke(currentStepCount)
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error initializing step counting", e)
                isInitialized = true // Still allow counting
            }
        }
    }
    
    /**
     * Load pause state from preferences.
     */
    private suspend fun loadPauseState() {
        withContext(Dispatchers.IO) {
            isPaused = repository.isPaused()
            withContext(Dispatchers.Main) {
                onPauseStateListener?.invoke(isPaused)
            }
        }
    }
    
    /**
     * Toggle pause state.
     */
    fun togglePause() {
        lifecycleScope.launch(Dispatchers.IO) {
            isPaused = !isPaused
            repository.setPaused(isPaused)
            
            withContext(Dispatchers.Main) {
                onPauseStateListener?.invoke(isPaused)
            }
            
            Log.d(TAG, "Pause state: $isPaused")
        }
    }
    
    /**
     * Get current pause state.
     */
    fun isPaused(): Boolean = isPaused
    
    /**
     * Start listening to step detector sensor.
     */
    private fun startSensorListening() {
        sensorManager?.let { manager ->
            stepDetectorSensor?.let { sensor ->
                // Use SENSOR_DELAY_GAME for better responsiveness but not too sensitive
                val registered = manager.registerListener(
                    this, 
                    sensor, 
                    SensorManager.SENSOR_DELAY_GAME
                )
                Log.d(TAG, "Step detector registered: $registered")
            } ?: run {
                Log.e(TAG, "No step detector sensor available on this device")
            }
        }
    }
    
    private fun stopSensorListening() {
        sensorManager?.unregisterListener(this)
    }
    
    override fun onSensorChanged(event: SensorEvent?) {
        if (!isInitialized || isPaused) return
        
        event?.let {
            if (it.sensor.type == Sensor.TYPE_STEP_DETECTOR) {
                handleStepDetected()
            }
        }
    }
    
    /**
     * Handle a single step detection with rate limiting.
     */
    private fun handleStepDetected() {
        val now = System.currentTimeMillis()
        val nowSecond = now / 1000
        
        // Rate limiting: Check if enough time has passed since last step
        if (now - lastStepTime < MIN_STEP_INTERVAL_MS) {
            Log.d(TAG, "Step ignored: too fast (${now - lastStepTime}ms)")
            return
        }
        
        // Check steps per second limit
        if (nowSecond == currentSecond) {
            if (stepsInCurrentSecond >= MAX_STEPS_PER_SECOND) {
                Log.d(TAG, "Step ignored: rate limit ($stepsInCurrentSecond steps this second)")
                return
            }
            stepsInCurrentSecond++
        } else {
            currentSecond = nowSecond
            stepsInCurrentSecond = 1
        }
        
        lastStepTime = now
        
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                currentStepCount++
                
                // Save to database
                repository.updateTodaySteps(currentStepCount)
                
                Log.d(TAG, "Step counted! Total: $currentStepCount")
                
                // Notify listener
                withContext(Dispatchers.Main) {
                    onStepUpdateListener?.invoke(currentStepCount)
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error handling step", e)
            }
        }
    }
    
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Log.d(TAG, "Sensor accuracy changed: $accuracy")
    }
    
    fun getCurrentStepCount(): Int = currentStepCount
    
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                getString(R.string.service_notification_channel),
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Step counter service"
                setShowBadge(false)
            }
            
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
    
    private fun createNotification(): Notification {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(getString(R.string.app_name))
            .setContentText(getString(R.string.step_counter_running))
            .setSmallIcon(R.drawable.ic_notification)
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        stopSensorListening()
        Log.d(TAG, "Service destroyed")
    }
}
