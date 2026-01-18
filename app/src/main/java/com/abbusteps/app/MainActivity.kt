package com.abbusteps.app

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.abbusteps.app.databinding.ActivityMainBinding
import com.abbusteps.app.service.StepCounterService
import com.abbusteps.app.ui.history.HistoryFragment
import com.abbusteps.app.ui.home.HomeFragment
import com.abbusteps.app.ui.settings.SettingsFragment
import com.abbusteps.app.util.PermissionHelper
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch

/**
 * Main activity of the app.
 * Handles permissions, starts step counter service, and manages navigation.
 */
class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    // Permission launcher for activity recognition
    private val activityRecognitionPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            startStepCounterService()
        } else {
            showPermissionDeniedDialog()
        }
    }
    
    // Permission launcher for notifications (Android 13+)
    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted
        } else {
            Toast.makeText(
                this,
                "Notifications disabled. You may not receive reminders.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            
            setupToolbar()
            setupViewPager()
            checkAndRequestPermissions()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            finish()
        }
    }
    
    /**
     * Setup toolbar.
     */
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }
    
    /**
     * Setup ViewPager with fragments.
     */
    private fun setupViewPager() {
        val adapter = MainPagerAdapter(this)
        binding.viewPager.adapter = adapter
        
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.app_name)
                1 -> getString(R.string.history)
                2 -> getString(R.string.settings)
                else -> ""
            }
        }.attach()
    }
    
    /**
     * Check and request necessary permissions.
     */
    private fun checkAndRequestPermissions() {
        // Check activity recognition permission (required for step counting)
        if (!PermissionHelper.hasActivityRecognitionPermission(this)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                activityRecognitionPermissionLauncher.launch(Manifest.permission.ACTIVITY_RECOGNITION)
            }
        } else {
            startStepCounterService()
        }
        
        // Check notification permission (Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (!PermissionHelper.hasNotificationPermission(this)) {
                notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }
    
    /**
     * Start the step counter service.
     */
    private fun startStepCounterService() {
        val serviceIntent = Intent(this, StepCounterService::class.java)
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent)
        } else {
            startService(serviceIntent)
        }
    }
    
    /**
     * Show dialog when permission is denied.
     */
    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(this)
            .setTitle(R.string.permission_required)
            .setMessage(R.string.activity_recognition_permission_message)
            .setPositiveButton(R.string.grant_permission) { _, _ ->
                checkAndRequestPermissions()
            }
            .setNegativeButton(R.string.cancel) { _, _ ->
                Toast.makeText(
                    this,
                    "Permission required for step counting",
                    Toast.LENGTH_LONG
                ).show()
            }
            .setCancelable(false)
            .show()
    }
    
    /**
     * ViewPager adapter for main fragments.
     */
    private class MainPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = 3
        
        override fun createFragment(position: Int): androidx.fragment.app.Fragment {
            return when (position) {
                0 -> HomeFragment()
                1 -> HistoryFragment()
                2 -> SettingsFragment()
                else -> HomeFragment()
            }
        }
    }
    
    override fun onDestroy() {
        super.onDestroy()
        // Service will continue running in background
    }
}

