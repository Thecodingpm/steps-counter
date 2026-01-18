package com.abbusteps.app.data.repository

import com.abbusteps.app.data.dao.StepRecordDao
import com.abbusteps.app.data.model.StepRecord
import com.abbusteps.app.data.preferences.PreferencesManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import java.util.Calendar

/**
 * Repository for managing step data.
 * Handles all data operations related to step counting.
 */
class StepRepository(
    private val stepRecordDao: StepRecordDao,
    private val preferencesManager: PreferencesManager
) {
    
    companion object {
        // Constants for calculations
        private const val AVERAGE_STEP_LENGTH_METERS = 0.75f // Average step length in meters
        private const val CALORIES_PER_STEP = 0.04f // Approximate calories per step
    }
    
    /**
     * Get today's step record.
     */
    fun getTodayStepRecord(): Flow<StepRecord?> {
        val today = StepRecord.getTodayDateString()
        return stepRecordDao.getTodayStepRecord(today)
    }
    
    /**
     * Get all step records.
     */
    fun getAllStepRecords(): Flow<List<StepRecord>> {
        return stepRecordDao.getAllStepRecords()
    }
    
    /**
     * Get step records for the last N days.
     */
    suspend fun getStepRecordsSince(days: Int): List<StepRecord> {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -days)
        val startDate = String.format(
            "%04d-%02d-%02d",
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1,
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        return stepRecordDao.getStepRecordsSince(startDate)
    }
    
    /**
     * Get weekly steps (last 7 days).
     */
    suspend fun getWeeklySteps(): Int {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -7)
        val startDate = String.format(
            "%04d-%02d-%02d",
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1,
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        return stepRecordDao.getWeeklySteps(startDate) ?: 0
    }
    
    /**
     * Get monthly steps (current month).
     */
    suspend fun getMonthlySteps(): Int {
        val calendar = Calendar.getInstance()
        val startDate = String.format(
            "%04d-%02d-01",
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1
        )
        val endDate = String.format(
            "%04d-%02d-%02d",
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1,
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        return stepRecordDao.getMonthlySteps(startDate, endDate) ?: 0
    }
    
    /**
     * Update steps for today.
     * This is called by the sensor service when new steps are detected.
     */
    suspend fun updateTodaySteps(steps: Int) {
        val today = StepRecord.getTodayDateString()
        val existingRecord = stepRecordDao.getStepRecord(today)
        
        // Calculate distance and calories
        val distanceKm = (steps * AVERAGE_STEP_LENGTH_METERS) / 1000f
        val calories = steps * CALORIES_PER_STEP
        
        if (existingRecord != null) {
            // Update existing record
            stepRecordDao.updateSteps(today, steps, distanceKm, calories, System.currentTimeMillis())
        } else {
            // Create new record
            val newRecord = StepRecord(
                date = today,
                steps = steps,
                distance = distanceKm,
                calories = calories,
                lastUpdated = System.currentTimeMillis()
            )
            stepRecordDao.insertStepRecord(newRecord)
        }
    }
    
    /**
     * Get daily goal from preferences.
     */
    fun getDailyGoal(): Flow<Int> {
        return preferencesManager.dailyGoal
    }
    
    /**
     * Set daily goal.
     */
    suspend fun setDailyGoal(goal: Int) {
        preferencesManager.setDailyGoal(goal)
    }
    
    /**
     * Get reminders enabled status.
     */
    fun isRemindersEnabled(): Flow<Boolean> {
        return preferencesManager.remindersEnabled
    }
    
    /**
     * Set reminders enabled.
     */
    suspend fun setRemindersEnabled(enabled: Boolean) {
        preferencesManager.setRemindersEnabled(enabled)
    }
    
    /**
     * Save last step counter value (for handling device reboot).
     */
    suspend fun saveLastStepCounterValue(value: Int) {
        preferencesManager.setLastStepCounterValue(value)
    }
    
    /**
     * Get last step counter value.
     */
    suspend fun getLastStepCounterValue(): Int {
        return preferencesManager.getLastStepCounterValue()
    }
    
    /**
     * Save last boot timestamp.
     */
    suspend fun saveLastBootTimestamp(timestamp: Long) {
        preferencesManager.setLastBootTimestamp(timestamp)
    }
    
    /**
     * Get last boot timestamp.
     */
    suspend fun getLastBootTimestamp(): Long {
        return preferencesManager.getLastBootTimestamp()
    }
    
    /**
     * Check if step counting is paused.
     */
    suspend fun isPaused(): Boolean {
        return preferencesManager.isPaused()
    }
    
    /**
     * Set pause state for step counting.
     */
    suspend fun setPaused(paused: Boolean) {
        preferencesManager.setPaused(paused)
    }
    
    /**
     * Reset today's step count to 0.
     */
    suspend fun resetTodaySteps() {
        updateTodaySteps(0)
    }
    
    /**
     * Set today's step count to a specific value.
     */
    suspend fun setTodaySteps(steps: Int) {
        updateTodaySteps(steps)
    }
}

