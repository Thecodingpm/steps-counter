package com.abbusteps.app.data.dao

import androidx.room.*
import com.abbusteps.app.data.model.StepRecord
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for StepRecord operations.
 */
@Dao
interface StepRecordDao {
    
    /**
     * Get step record for a specific date.
     */
    @Query("SELECT * FROM step_records WHERE date = :date")
    suspend fun getStepRecord(date: String): StepRecord?
    
    /**
     * Get today's step record.
     */
    @Query("SELECT * FROM step_records WHERE date = :date")
    fun getTodayStepRecord(date: String): Flow<StepRecord?>
    
    /**
     * Get all step records ordered by date (descending).
     */
    @Query("SELECT * FROM step_records ORDER BY date DESC")
    fun getAllStepRecords(): Flow<List<StepRecord>>
    
    /**
     * Get step records for a date range.
     */
    @Query("SELECT * FROM step_records WHERE date BETWEEN :startDate AND :endDate ORDER BY date ASC")
    suspend fun getStepRecordsBetween(startDate: String, endDate: String): List<StepRecord>
    
    /**
     * Get step records for the last N days.
     */
    @Query("SELECT * FROM step_records WHERE date >= :startDate ORDER BY date ASC")
    suspend fun getStepRecordsSince(startDate: String): List<StepRecord>
    
    /**
     * Get weekly total steps (last 7 days).
     */
    @Query("SELECT SUM(steps) FROM step_records WHERE date >= :startDate")
    suspend fun getWeeklySteps(startDate: String): Int?
    
    /**
     * Get monthly total steps.
     */
    @Query("SELECT SUM(steps) FROM step_records WHERE date >= :startDate AND date <= :endDate")
    suspend fun getMonthlySteps(startDate: String, endDate: String): Int?
    
    /**
     * Insert or update a step record.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStepRecord(stepRecord: StepRecord)
    
    /**
     * Update steps for a specific date.
     */
    @Query("UPDATE step_records SET steps = :steps, distance = :distance, calories = :calories, lastUpdated = :lastUpdated WHERE date = :date")
    suspend fun updateSteps(date: String, steps: Int, distance: Float, calories: Float, lastUpdated: Long)
    
    /**
     * Delete all step records.
     */
    @Query("DELETE FROM step_records")
    suspend fun deleteAll()
}

