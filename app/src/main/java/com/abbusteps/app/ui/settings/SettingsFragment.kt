package com.abbusteps.app.ui.settings

import android.content.pm.PackageInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.abbusteps.app.databinding.FragmentSettingsBinding
import com.abbusteps.app.viewmodel.SettingsViewModel
import kotlinx.coroutines.launch

/**
 * Settings fragment for app configuration.
 */
class SettingsFragment : Fragment() {
    
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: SettingsViewModel by viewModels()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupViews()
        observeViewModel()
    }
    
    /**
     * Setup UI components.
     */
    private fun setupViews() {
        // Version text
        try {
            val ctx = requireContext()
            val versionName = ctx.packageManager.getPackageInfo(ctx.packageName, 0).versionName
            binding.tvVersion.text = getString(com.abbusteps.app.R.string.version, versionName)
        } catch (e: Exception) {
            binding.tvVersion.text = getString(com.abbusteps.app.R.string.version, "1.0.0")
        }
        
        // Save goal button
        binding.btnSaveGoal.setOnClickListener {
            saveDailyGoal()
        }
        
        // Reminders switch
        binding.switchReminders.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateRemindersEnabled(isChecked)
        }
    }
    
    /**
     * Observe ViewModel data.
     */
    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dailyGoal.collect { goal ->
                binding.etDailyGoal.setText(goal.toString())
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.remindersEnabled.collect { enabled ->
                binding.switchReminders.isChecked = enabled
            }
        }
    }
    
    /**
     * Save daily goal.
     */
    private fun saveDailyGoal() {
        val goalText = binding.etDailyGoal.text?.toString()
        if (goalText.isNullOrBlank()) {
            Toast.makeText(context, "Please enter a valid goal", Toast.LENGTH_SHORT).show()
            return
        }
        
        val goal = goalText.toIntOrNull()
        if (goal == null || goal <= 0) {
            Toast.makeText(context, "Please enter a valid positive number", Toast.LENGTH_SHORT).show()
            return
        }
        
        viewModel.updateDailyGoal(goal)
        Toast.makeText(context, "Daily goal saved!", Toast.LENGTH_SHORT).show()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

