package com.abbusteps.app.service;

/**
 * Foreground service for step counting.
 * Uses TYPE_STEP_DETECTOR with rate limiting and debouncing.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00029:B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\u0006\u0010\"\u001a\u00020\tJ\b\u0010#\u001a\u00020\u0010H\u0002J\u000e\u0010$\u001a\u00020\u0010H\u0082@\u00a2\u0006\u0002\u0010%J\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010&\u001a\u00020\u0010H\u0082@\u00a2\u0006\u0002\u0010%J\u001a\u0010\'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u001d2\u0006\u0010)\u001a\u00020\tH\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0010H\u0016J\b\u0010/\u001a\u00020\u0010H\u0016J\u0012\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102H\u0016J\"\u00103\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J\b\u00106\u001a\u00020\u0010H\u0002J\b\u00107\u001a\u00020\u0010H\u0002J\u0006\u00108\u001a\u00020\u0010R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/abbusteps/app/service/StepCounterService;", "Landroidx/lifecycle/LifecycleService;", "Landroid/hardware/SensorEventListener;", "()V", "binder", "Lcom/abbusteps/app/service/StepCounterService$LocalBinder;", "currentSecond", "", "currentStepCount", "", "isInitialized", "", "isPaused", "lastStepTime", "onPauseStateListener", "Lkotlin/Function1;", "", "getOnPauseStateListener", "()Lkotlin/jvm/functions/Function1;", "setOnPauseStateListener", "(Lkotlin/jvm/functions/Function1;)V", "onStepUpdateListener", "getOnStepUpdateListener", "setOnStepUpdateListener", "repository", "Lcom/abbusteps/app/data/repository/StepRepository;", "sensorManager", "Landroid/hardware/SensorManager;", "stepDetectorSensor", "Landroid/hardware/Sensor;", "stepsInCurrentSecond", "createNotification", "Landroid/app/Notification;", "createNotificationChannel", "getCurrentStepCount", "handleStepDetected", "initializeStepCounting", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPauseState", "onAccuracyChanged", "sensor", "accuracy", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "onStartCommand", "flags", "startId", "startSensorListening", "stopSensorListening", "togglePause", "Companion", "LocalBinder", "app_debug"})
public final class StepCounterService extends androidx.lifecycle.LifecycleService implements android.hardware.SensorEventListener {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "StepCounterService";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHANNEL_ID = "step_counter_channel";
    private static final int NOTIFICATION_ID = 1001;
    private static final long MIN_STEP_INTERVAL_MS = 300L;
    private static final int MAX_STEPS_PER_SECOND = 3;
    @org.jetbrains.annotations.NotNull
    private final com.abbusteps.app.service.StepCounterService.LocalBinder binder = null;
    private com.abbusteps.app.data.repository.StepRepository repository;
    @org.jetbrains.annotations.Nullable
    private android.hardware.SensorManager sensorManager;
    @org.jetbrains.annotations.Nullable
    private android.hardware.Sensor stepDetectorSensor;
    private int currentStepCount = 0;
    private boolean isInitialized = false;
    private boolean isPaused = false;
    private long lastStepTime = 0L;
    private int stepsInCurrentSecond = 0;
    private long currentSecond = 0L;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onStepUpdateListener;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onPauseStateListener;
    @org.jetbrains.annotations.NotNull
    public static final com.abbusteps.app.service.StepCounterService.Companion Companion = null;
    
    public StepCounterService() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnStepUpdateListener() {
        return null;
    }
    
    public final void setOnStepUpdateListener(@org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> getOnPauseStateListener() {
        return null;
    }
    
    public final void setOnPauseStateListener(@org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
    
    /**
     * Initialize step counting from saved state.
     */
    private final java.lang.Object initializeStepCounting(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Load pause state from preferences.
     */
    private final java.lang.Object loadPauseState(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Toggle pause state.
     */
    public final void togglePause() {
    }
    
    /**
     * Get current pause state.
     */
    public final boolean isPaused() {
        return false;
    }
    
    /**
     * Start listening to step detector sensor.
     */
    private final void startSensorListening() {
    }
    
    private final void stopSensorListening() {
    }
    
    @java.lang.Override
    public void onSensorChanged(@org.jetbrains.annotations.Nullable
    android.hardware.SensorEvent event) {
    }
    
    /**
     * Handle a single step detection with rate limiting.
     */
    private final void handleStepDetected() {
    }
    
    @java.lang.Override
    public void onAccuracyChanged(@org.jetbrains.annotations.Nullable
    android.hardware.Sensor sensor, int accuracy) {
    }
    
    public final int getCurrentStepCount() {
        return 0;
    }
    
    private final void createNotificationChannel() {
    }
    
    private final android.app.Notification createNotification() {
        return null;
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/abbusteps/app/service/StepCounterService$Companion;", "", "()V", "CHANNEL_ID", "", "MAX_STEPS_PER_SECOND", "", "MIN_STEP_INTERVAL_MS", "", "NOTIFICATION_ID", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/abbusteps/app/service/StepCounterService$LocalBinder;", "Landroid/os/Binder;", "(Lcom/abbusteps/app/service/StepCounterService;)V", "getService", "Lcom/abbusteps/app/service/StepCounterService;", "app_debug"})
    public final class LocalBinder extends android.os.Binder {
        
        public LocalBinder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.abbusteps.app.service.StepCounterService getService() {
            return null;
        }
    }
}