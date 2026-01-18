package com.abbusteps.app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.abbusteps.app.service.StepCounterService

/**
 * Broadcast receiver that restarts the step counter service after device reboot.
 * This ensures step counting continues even after device restart.
 */
class BootReceiver : BroadcastReceiver() {
    
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED ||
            intent.action == Intent.ACTION_MY_PACKAGE_REPLACED ||
            intent.action == Intent.ACTION_PACKAGE_REPLACED
        ) {
            // Start the step counter service
            val serviceIntent = Intent(context, StepCounterService::class.java)
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntent)
            } else {
                context.startService(serviceIntent)
            }
        }
    }
}

