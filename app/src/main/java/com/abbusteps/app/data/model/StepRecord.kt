package com.abbusteps.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar

/**
 * Entity representing a daily step record.
 * Stores step count for each calendar day.
 */
@Entity(tableName = "step_records")
data class StepRecord(
    @PrimaryKey
    val date: String, // Format: "yyyy-MM-dd"
    val steps: Int = 0,
    val distance: Float = 0f, // in kilometers
    val calories: Float = 0f, // in kcal
    val lastUpdated: Long = System.currentTimeMillis()
) {
    companion object {
        /**
         * Get today's date string in format "yyyy-MM-dd"
         */
        fun getTodayDateString(): String {
            val calendar = Calendar.getInstance()
            return String.format(
                "%04d-%02d-%02d",
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH)
            )
        }
        
        /**
         * Get date string for given day offset (0 = today, -1 = yesterday, etc.)
         */
        fun getDateString(dayOffset: Int): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, dayOffset)
            return String.format(
                "%04d-%02d-%02d",
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH)
            )
        }
    }
}

