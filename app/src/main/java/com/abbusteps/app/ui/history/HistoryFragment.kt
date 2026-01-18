package com.abbusteps.app.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.abbusteps.app.databinding.FragmentHistoryBinding
import com.google.android.material.tabs.TabLayoutMediator

/**
 * History fragment with tabs for weekly and monthly views.
 */
class HistoryFragment : Fragment() {
    
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupViewPager()
    }
    
    /**
     * Setup ViewPager with tabs.
     */
    private fun setupViewPager() {
        val adapter = HistoryPagerAdapter(this)
        binding.viewPager.adapter = adapter
        
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Weekly"
                1 -> "Monthly"
                else -> ""
            }
        }.attach()
    }
    
    /**
     * ViewPager adapter for history fragments.
     */
    private class HistoryPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 2
        
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> WeeklyHistoryFragment()
                1 -> MonthlyHistoryFragment()
                else -> WeeklyHistoryFragment()
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

