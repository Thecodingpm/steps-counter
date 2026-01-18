package com.abbusteps.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.abbusteps.app.AbbuStepsApplication
import com.abbusteps.app.data.model.StepRecord
import com.abbusteps.app.data.repository.StepRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for step counting data.
 * Provides step count, history, and statistics.
 */
class StepViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository: StepRepository = (application as AbbuStepsApplication).repository
    
    // Today's step record
    private val _todayStepRecord = MutableStateFlow<StepRecord?>(null)
    val todayStepRecord: StateFlow<StepRecord?> = _todayStepRecord.asStateFlow()
    
    // Daily goal
    private val _dailyGoal = MutableStateFlow(10000)
    val dailyGoal: StateFlow<Int> = _dailyGoal.asStateFlow()
    
    // Weekly steps
    private val _weeklySteps = MutableStateFlow(0)
    val weeklySteps: StateFlow<Int> = _weeklySteps.asStateFlow()
    
    // Monthly steps
    private val _monthlySteps = MutableStateFlow(0)
    val monthlySteps: StateFlow<Int> = _monthlySteps.asStateFlow()
    
    // All step records for history
    private val _allStepRecords = MutableStateFlow<List<StepRecord>>(emptyList())
    val allStepRecords: StateFlow<List<StepRecord>> = _allStepRecords.asStateFlow()
    
    // Goal achievement flag
    private val _goalAchieved = MutableLiveData<Boolean>(false)
    val goalAchieved: LiveData<Boolean> = _goalAchieved
    
    init {
        loadTodayStepRecord()
        loadDailyGoal()
        loadWeeklySteps()
        loadMonthlySteps()
        loadAllStepRecords()
    }
    
    /**
     * Load today's step record.
     */
    private fun loadTodayStepRecord() {
        viewModelScope.launch {
            repository.getTodayStepRecord().collect { record ->
                _todayStepRecord.value = record
                
                // Check if goal is achieved
                val goal = _dailyGoal.value
                val steps = record?.steps ?: 0
                val wasAchieved = _goalAchieved.value ?: false
                val isAchieved = steps >= goal
                
                if (isAchieved && !wasAchieved) {
                    _goalAchieved.postValue(true)
                } else if (!isAchieved) {
                    _goalAchieved.postValue(false)
                }
            }
        }
    }
    
    /**
     * Load daily goal from preferences.
     */
    private fun loadDailyGoal() {
        viewModelScope.launch {
            repository.getDailyGoal().collect { goal ->
                _dailyGoal.value = goal
            }
        }
    }
    
    /**
     * Load weekly steps.
     */
    fun loadWeeklySteps() {
        viewModelScope.launch {
            val steps = repository.getWeeklySteps()
            _weeklySteps.value = steps
        }
    }
    
    /**
     * Load monthly steps.
     */
    fun loadMonthlySteps() {
        viewModelScope.launch {
            val steps = repository.getMonthlySteps()
            _monthlySteps.value = steps
        }
    }
    
    /**
     * Load all step records for history.
     */
    private fun loadAllStepRecords() {
        viewModelScope.launch {
            repository.getAllStepRecords().collect { records ->
                _allStepRecords.value = records
            }
        }
    }
    
    /**
     * Get step records for the last N days.
     */
    fun getStepRecordsSince(days: Int): List<StepRecord> {
        return _allStepRecords.value.filter { record ->
            // Filter records from the last N days
            val recordDate = java.time.LocalDate.parse(record.date)
            val today = java.time.LocalDate.now()
            val daysAgo = today.minusDays(days.toLong())
            recordDate.isAfter(daysAgo) || recordDate.isEqual(today)
        }
    }
    
    /**
     * Update daily goal.
     */
    fun updateDailyGoal(goal: Int) {
        viewModelScope.launch {
            repository.setDailyGoal(goal)
        }
    }
    
    /**
     * Refresh all data.
     */
    fun refresh() {
        loadWeeklySteps()
        loadMonthlySteps()
    }
    
    /**
     * Reset today's step count to 0.
     */
    suspend fun resetTodaySteps() {
        repository.resetTodaySteps()
    }
    
    /**
     * Set today's step count to a specific value.
     */
    suspend fun setTodaySteps(steps: Int) {
        repository.setTodaySteps(steps)
    }
}

