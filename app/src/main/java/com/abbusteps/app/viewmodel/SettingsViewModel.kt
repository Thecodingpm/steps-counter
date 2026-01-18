package com.abbusteps.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.abbusteps.app.AbbuStepsApplication
import com.abbusteps.app.data.repository.StepRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for settings.
 */
class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository: StepRepository = (application as AbbuStepsApplication).repository
    
    // Daily goal
    private val _dailyGoal = MutableStateFlow(10000)
    val dailyGoal: StateFlow<Int> = _dailyGoal.asStateFlow()
    
    // Reminders enabled
    private val _remindersEnabled = MutableStateFlow(true)
    val remindersEnabled: StateFlow<Boolean> = _remindersEnabled.asStateFlow()
    
    init {
        loadSettings()
    }
    
    /**
     * Load settings from repository.
     */
    private fun loadSettings() {
        viewModelScope.launch {
            repository.getDailyGoal().collect { goal ->
                _dailyGoal.value = goal
            }
        }
        
        viewModelScope.launch {
            repository.isRemindersEnabled().collect { enabled ->
                _remindersEnabled.value = enabled
            }
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
     * Update reminders enabled.
     */
    fun updateRemindersEnabled(enabled: Boolean) {
        viewModelScope.launch {
            repository.setRemindersEnabled(enabled)
        }
    }
}

