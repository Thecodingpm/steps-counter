package com.abbusteps.app.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * Manages app preferences using DataStore.
 */
class PreferencesManager(private val context: Context) {
    
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "abbusteps_preferences")
        
        // Preference keys
        private val DAILY_GOAL_KEY = intPreferencesKey("daily_step_goal")
        private val REMINDERS_ENABLED_KEY = booleanPreferencesKey("reminders_enabled")
        private val LAST_STEP_COUNTER_VALUE_KEY = intPreferencesKey("last_step_counter_value")
        private val LAST_BOOT_TIMESTAMP_KEY = longPreferencesKey("last_boot_timestamp")
        private val PAUSED_KEY = booleanPreferencesKey("step_counting_paused")
        
        // Default values
        private const val DEFAULT_DAILY_GOAL = 10000
    }
    
    /**
     * Get daily step goal.
     */
    val dailyGoal: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[DAILY_GOAL_KEY] ?: DEFAULT_DAILY_GOAL
    }
    
    /**
     * Set daily step goal.
     */
    suspend fun setDailyGoal(goal: Int) {
        context.dataStore.edit { preferences ->
            preferences[DAILY_GOAL_KEY] = goal
        }
    }
    
    /**
     * Get reminders enabled status.
     */
    val remindersEnabled: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[REMINDERS_ENABLED_KEY] ?: true
    }
    
    /**
     * Set reminders enabled.
     */
    suspend fun setRemindersEnabled(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[REMINDERS_ENABLED_KEY] = enabled
        }
    }
    
    /**
     * Get last step counter value (for handling device reboot).
     */
    suspend fun getLastStepCounterValue(): Int {
        return context.dataStore.data.map { preferences ->
            preferences[LAST_STEP_COUNTER_VALUE_KEY] ?: 0
        }.first()
    }
    
    /**
     * Set last step counter value.
     */
    suspend fun setLastStepCounterValue(value: Int) {
        context.dataStore.edit { preferences ->
            preferences[LAST_STEP_COUNTER_VALUE_KEY] = value
        }
    }
    
    /**
     * Get last boot timestamp.
     */
    suspend fun getLastBootTimestamp(): Long {
        return context.dataStore.data.map { preferences ->
            preferences[LAST_BOOT_TIMESTAMP_KEY] ?: 0L
        }.first()
    }
    
    /**
     * Set last boot timestamp.
     */
    suspend fun setLastBootTimestamp(timestamp: Long) {
        context.dataStore.edit { preferences ->
            preferences[LAST_BOOT_TIMESTAMP_KEY] = timestamp
        }
    }
    
    /**
     * Get paused state.
     */
    suspend fun isPaused(): Boolean {
        return context.dataStore.data.map { preferences ->
            preferences[PAUSED_KEY] ?: false
        }.first()
    }
    
    /**
     * Set paused state.
     */
    suspend fun setPaused(paused: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PAUSED_KEY] = paused
        }
    }
}

