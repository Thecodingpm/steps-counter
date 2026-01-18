package com.abbusteps.app.ui.home

import android.app.AlertDialog
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.abbusteps.app.R
import com.abbusteps.app.databinding.FragmentHomeBinding
import com.abbusteps.app.service.StepCounterService
import com.abbusteps.app.viewmodel.StepViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Home fragment with goal progress display and clickable day circles.
 */
class HomeFragment : Fragment() {
    
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: StepViewModel by viewModels()
    
    private val decimalFormat = DecimalFormat("#.#")
    private val dateFormat = SimpleDateFormat("EEEE, MMM d", Locale.getDefault())
    
    private var stepService: StepCounterService? = null
    private var serviceBound = false
    
    // Days of week data
    private val dayContainers = mutableListOf<View>()
    private val dayCircles = mutableListOf<View>()
    
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as? StepCounterService.LocalBinder
            stepService = binder?.getService()
            serviceBound = true
            
            stepService?.onStepUpdateListener = { steps ->
                activity?.runOnUiThread {
                    updateStepDisplay(steps)
                }
            }
            
            stepService?.onPauseStateListener = { isPaused ->
                activity?.runOnUiThread {
                    updatePauseState(isPaused)
                }
            }
            
            stepService?.let { service ->
                updatePauseState(service.isPaused())
            }
        }
        
        override fun onServiceDisconnected(name: ComponentName?) {
            stepService = null
            serviceBound = false
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupDayContainers()
        setupClickListeners()
        observeViewModel()
    }
    
    private fun setupDayContainers() {
        dayContainers.clear()
        dayContainers.addAll(listOf(
            binding.dayContainer1, binding.dayContainer2, binding.dayContainer3,
            binding.dayContainer4, binding.dayContainer5, binding.dayContainer6,
            binding.dayContainer7
        ))
        
        dayCircles.clear()
        dayCircles.addAll(listOf(
            binding.dayCircle1, binding.dayCircle2, binding.dayCircle3,
            binding.dayCircle4, binding.dayCircle5, binding.dayCircle6,
            binding.dayCircle7
        ))
        
        // Set up click listeners for each day
        dayContainers.forEachIndexed { index, container ->
            container.setOnClickListener {
                showDayData(index)
            }
        }
    }
    
    override fun onStart() {
        super.onStart()
        Intent(requireContext(), StepCounterService::class.java).also { intent ->
            requireContext().bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }
    }
    
    override fun onStop() {
        super.onStop()
        if (serviceBound) {
            requireContext().unbindService(serviceConnection)
            serviceBound = false
        }
    }
    
    private fun setupClickListeners() {
        binding.fabPlayPause.setOnClickListener {
            stepService?.togglePause()
        }
        
        binding.btnMenu.setOnClickListener {
            showMenuBottomSheet()
        }
        
        binding.tvDetailLink.setOnClickListener {
            (activity as? com.abbusteps.app.MainActivity)?.let { mainActivity ->
                mainActivity.findViewById<androidx.viewpager2.widget.ViewPager2>(R.id.viewPager)?.currentItem = 1
            }
        }
    }
    
    private fun showDayData(dayIndex: Int) {
        // Get date for the selected day (0 = Monday, 6 = Sunday)
        val calendar = Calendar.getInstance()
        val currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        
        // Convert to Monday=0 format
        val todayIndex = if (currentDayOfWeek == Calendar.SUNDAY) 6 else currentDayOfWeek - 2
        val daysAgo = todayIndex - dayIndex
        
        calendar.add(Calendar.DAY_OF_YEAR, -daysAgo)
        val dateString = dateFormat.format(calendar.time)
        
        // Format for database query
        val dbDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dbDate = dbDateFormat.format(calendar.time)
        
        // Query data for this day
        viewLifecycleOwner.lifecycleScope.launch {
            val records = viewModel.allStepRecords.value
            val record = records.find { it.date == dbDate }
            
            val steps = record?.steps ?: 0
            val calories = record?.calories ?: 0f
            val timeMinutes = (steps / 100).coerceAtLeast(0)
            val hours = timeMinutes / 60
            val minutes = timeMinutes % 60
            
            // Show selected day card
            binding.selectedDayCard.visibility = View.VISIBLE
            binding.tvSelectedDayTitle.text = dateString
            binding.tvSelectedDaySteps.text = formatNumber(steps)
            binding.tvSelectedDayCalories.text = decimalFormat.format(calories)
            binding.tvSelectedDayTime.text = if (hours > 0) "${hours}h ${minutes}m" else "${minutes}m"
        }
    }
    
    private fun showMenuBottomSheet() {
        val dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        val view = layoutInflater.inflate(R.layout.bottom_sheet_menu, null)
        dialog.setContentView(view)
        
        view.findViewById<View>(R.id.btnClose).setOnClickListener {
            dialog.dismiss()
        }
        
        view.findViewById<View>(R.id.cardResetSteps).setOnClickListener {
            dialog.dismiss()
            showResetConfirmDialog()
        }
        
        view.findViewById<View>(R.id.cardEditSteps).setOnClickListener {
            dialog.dismiss()
            showEditStepsDialog()
        }
        
        view.findViewById<View>(R.id.cardTurnOff).setOnClickListener {
            dialog.dismiss()
            stepService?.let { service ->
                if (!service.isPaused()) {
                    service.togglePause()
                }
            }
            Toast.makeText(requireContext(), "Step counting turned off", Toast.LENGTH_SHORT).show()
        }
        
        view.findViewById<View>(R.id.cardFaq).setOnClickListener {
            dialog.dismiss()
            showFaqDialog()
        }
        
        dialog.show()
    }
    
    private fun showResetConfirmDialog() {
        AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
            .setTitle(getString(R.string.reset_steps))
            .setMessage(getString(R.string.reset_confirm))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.resetTodaySteps()
                    updateStepDisplay(0)
                    Toast.makeText(requireContext(), "Steps reset", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(getString(R.string.no), null)
            .show()
    }
    
    private fun showEditStepsDialog() {
        val input = EditText(requireContext())
        input.hint = getString(R.string.enter_steps)
        input.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        input.setPadding(48, 32, 48, 32)
        
        AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
            .setTitle(getString(R.string.edit_steps))
            .setView(input)
            .setPositiveButton("OK") { _, _ ->
                val newSteps = input.text.toString().toIntOrNull()
                if (newSteps != null && newSteps >= 0) {
                    viewLifecycleOwner.lifecycleScope.launch {
                        viewModel.setTodaySteps(newSteps)
                        updateStepDisplay(newSteps)
                        Toast.makeText(requireContext(), "Steps updated", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            .setNegativeButton(getString(R.string.cancel), null)
            .show()
    }
    
    private fun showFaqDialog() {
        AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
            .setTitle(getString(R.string.faq))
            .setMessage("""
                How does Step Counter work?
                The app uses your phone's step sensor to count steps.
                
                Why aren't my steps counting?
                Make sure to grant Activity Recognition permission and keep the app running.
                
                What does Pause do?
                When paused, the app won't count new steps until you resume.
                
                Can I reset my steps?
                Yes, use the Reset steps option to set today's count to 0.
            """.trimIndent())
            .setPositiveButton("OK", null)
            .show()
    }
    
    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.todayStepRecord.collect { record ->
                val steps = record?.steps ?: 0
                val calories = record?.calories ?: 0f
                val distance = record?.distance ?: 0f
                
                updateStepDisplay(steps)
                updateDistance(distance)
                updateCalories(calories)
                updateActiveTime(steps)
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dailyGoal.collect { goal ->
                updateGoalProgress(goal)
            }
        }
    }
    
    private fun updateStepDisplay(steps: Int) {
        binding.tvStepCount.text = formatNumber(steps)
        updateGoalProgress(viewModel.dailyGoal.value)
    }
    
    private fun updateGoalProgress(goal: Int) {
        val steps = viewModel.todayStepRecord.value?.steps ?: 0
        
        // Update progress bar
        binding.progressBar.max = goal
        binding.progressBar.progress = steps.coerceAtMost(goal)
        
        // Update goal text (e.g., "1,234 / 10,000")
        binding.tvGoalProgress.text = "${formatNumber(steps)} / ${formatNumber(goal)}"
        
        // Update steps left text
        val stepsLeft = (goal - steps).coerceAtLeast(0)
        if (stepsLeft > 0) {
            binding.tvStepsLeft.text = getString(R.string.steps_left_format, stepsLeft)
        } else {
            binding.tvStepsLeft.text = getString(R.string.goal_reached)
        }
    }
    
    private fun updatePauseState(isPaused: Boolean) {
        if (isPaused) {
            binding.fabPlayPause.setImageResource(R.drawable.ic_play)
            binding.tvPausedBadge.visibility = View.VISIBLE
        } else {
            binding.fabPlayPause.setImageResource(R.drawable.ic_pause)
            binding.tvPausedBadge.visibility = View.GONE
        }
    }
    
    private fun updateDistance(distanceKm: Float) {
        binding.tvDistance.text = decimalFormat.format(distanceKm)
    }
    
    private fun updateCalories(calories: Float) {
        binding.tvCalories.text = decimalFormat.format(calories)
    }
    
    private fun updateActiveTime(steps: Int) {
        val totalMinutes = (steps / 100).coerceAtLeast(0)
        val hours = totalMinutes / 60
        val minutes = totalMinutes % 60
        binding.tvActiveTime.text = if (hours > 0) "${hours}h ${minutes}m" else "${minutes}m"
    }
    
    private fun formatNumber(number: Int): String {
        return String.format("%,d", number)
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
