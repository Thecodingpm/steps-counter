package com.abbusteps.app.ui.history

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.abbusteps.app.databinding.FragmentHistoryMonthlyBinding
import com.abbusteps.app.viewmodel.StepViewModel
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.coroutines.launch
import java.util.Calendar

/**
 * Monthly history fragment showing line chart of current month.
 */
class MonthlyHistoryFragment : Fragment() {
    
    private var _binding: FragmentHistoryMonthlyBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: StepViewModel by viewModels()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryMonthlyBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupChart()
        observeViewModel()
    }
    
    /**
     * Setup line chart.
     */
    private fun setupChart() {
        with(binding.lineChart) {
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
            viewModel.monthlySteps.collect { total ->
                binding.tvMonthlyTotal.text = "Total: ${String.format("%,d", total)} steps"
            }
        }
    }
    
    /**
     * Update chart with monthly data.
     */
    private fun updateChart(records: List<com.abbusteps.app.data.model.StepRecord>) {
        val calendar = Calendar.getInstance()
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        
        val entries = mutableListOf<Entry>()
        val labels = mutableListOf<String>()
        
        for (day in 1..currentDay) {
            val dateString = String.format(
                "%04d-%02d-%02d",
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                day
            )
            
            val record = records.find { it.date == dateString }
            val steps = record?.steps?.toFloat() ?: 0f
            
            entries.add(Entry(day.toFloat(), steps))
            labels.add(day.toString())
        }
        
        if (entries.isNotEmpty()) {
            val dataSet = LineDataSet(entries, "Steps").apply {
                color = Color.parseColor("#2196F3")
                valueTextColor = Color.parseColor("#757575")
                valueTextSize = 10f
                lineWidth = 3f
                setCircleColor(Color.parseColor("#2196F3"))
                circleRadius = 4f
                mode = LineDataSet.Mode.CUBIC_BEZIER
                setDrawFilled(true)
                fillColor = Color.parseColor("#BBDEFB")
            }
            
            val data = LineData(dataSet)
            binding.lineChart.data = data
            binding.lineChart.xAxis.valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    val day = value.toInt()
                    return if (day % 5 == 0) day.toString() else ""
                }
            }
            binding.lineChart.invalidate()
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

