package com.abbusteps.app.ui.history

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.abbusteps.app.R
import com.abbusteps.app.databinding.FragmentHistoryWeeklyBinding
import com.abbusteps.app.viewmodel.StepViewModel
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * Weekly history fragment showing bar chart of last 7 days.
 */
class WeeklyHistoryFragment : Fragment() {
    
    private var _binding: FragmentHistoryWeeklyBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: StepViewModel by viewModels()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryWeeklyBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupChart()
        observeViewModel()
    }
    
    /**
     * Setup bar chart.
     */
    private fun setupChart() {
        with(binding.barChart) {
            description.isEnabled = false
            setTouchEnabled(true)
            setDragEnabled(false)
            setScaleEnabled(false)
            setPinchZoom(false)
            
            legend.isEnabled = false
            
            axisLeft.apply {
                axisMinimum = 0f
                setDrawGridLines(true)
                gridColor = Color.parseColor("#E0E0E0")
            }
            
            axisRight.isEnabled = false
            
            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                setDrawGridLines(false)
                granularity = 1f
                textColor = Color.parseColor("#757575")
            }
        }
    }
    
    /**
     * Observe ViewModel and update chart.
     */
    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.allStepRecords.collect { records ->
                updateChart(records)
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.weeklySteps.collect { total ->
                binding.tvWeeklyTotal.text = "Total: ${String.format("%,d", total)} steps"
            }
        }
    }
    
    /**
     * Update chart with weekly data.
     */
    private fun updateChart(records: List<com.abbusteps.app.data.model.StepRecord>) {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("EEE", Locale.getDefault())
        
        // Get last 7 days
        val entries = mutableListOf<BarEntry>()
        val labels = mutableListOf<String>()
        
        for (i in 6 downTo 0) {
            val tempCalendar = Calendar.getInstance()
            tempCalendar.add(Calendar.DAY_OF_YEAR, -i)
            
            val dateString = String.format(
                "%04d-%02d-%02d",
                tempCalendar.get(Calendar.YEAR),
                tempCalendar.get(Calendar.MONTH) + 1,
                tempCalendar.get(Calendar.DAY_OF_MONTH)
            )
            
            val record = records.find { it.date == dateString }
            val steps = record?.steps?.toFloat() ?: 0f
            
            entries.add(BarEntry((6 - i).toFloat(), steps))
            labels.add(dateFormat.format(tempCalendar.time))
        }
        
        val dataSet = BarDataSet(entries, "Steps").apply {
            color = Color.parseColor("#2196F3")
            valueTextColor = Color.parseColor("#757575")
            valueTextSize = 10f
        }
        
        val data = BarData(dataSet).apply {
            barWidth = 0.5f
        }
        
        binding.barChart.data = data
        binding.barChart.xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                val index = value.toInt()
                return if (index >= 0 && index < labels.size) labels[index] else ""
            }
        }
        binding.barChart.invalidate()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

