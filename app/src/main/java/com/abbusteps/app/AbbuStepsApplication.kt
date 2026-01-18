package com.abbusteps.app

import android.app.Application
import android.content.Context
import com.abbusteps.app.data.database.AppDatabase
import com.abbusteps.app.data.preferences.PreferencesManager
import com.abbusteps.app.data.repository.StepRepository

/**
 * Application class for Abbu Steps app.
 * Provides singleton instances of database and repository.
 */
class AbbuStepsApplication : Application() {
    
    // Lazy initialization of database
    val database by lazy { AppDatabase.getDatabase(this) }
    
    // Lazy initialization of preferences manager
    val preferencesManager by lazy { PreferencesManager(this) }
    
    // Lazy initialization of repository
    val repository by lazy {
        StepRepository(
            database.stepRecordDao(),
            preferencesManager
        )
    }
    
    companion object {
        @Volatile
        private var INSTANCE: AbbuStepsApplication? = null
        
        fun getInstance(context: Context): AbbuStepsApplication {
            return INSTANCE ?: synchronized(this) {
                val instance = context.applicationContext as AbbuStepsApplication
                INSTANCE = instance
                instance
            }
        }
    }
    
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

