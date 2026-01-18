package com.abbusteps.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abbusteps.app.data.dao.StepRecordDao
import com.abbusteps.app.data.model.StepRecord

/**
 * Room Database for storing step records.
 */
@Database(
    entities = [StepRecord::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun stepRecordDao(): StepRecordDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "abbusteps_database"
                )
                    .fallbackToDestructiveMigration() // For simplicity in v1
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

