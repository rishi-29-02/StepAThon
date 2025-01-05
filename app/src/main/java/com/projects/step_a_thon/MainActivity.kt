package com.projects.step_a_thon

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.projects.step_a_thon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        binding.viewPager.isUserInputEnabled = false

        val tabCount = viewPagerAdapter.itemCount
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()

        setTabLayoutParams(tabCount)

        setOnEventListeners()
    }

    private fun setTabLayoutParams(tabCount: Int) {
        for (i in 0 until tabCount) {
            val tab = binding.tabLayout.getTabAt(i)
            val params = tab?.view?.layoutParams as LinearLayout.LayoutParams
            params.setMargins(16, 0, 16, 0)
            tab.view.layoutParams = params
        }
    }

    private fun setOnEventListeners() {
        binding.root.setOnClickListener {
            val currentItem = binding.viewPager.currentItem
            val nextItem = currentItem + 1
            if (currentItem < viewPagerAdapter.itemCount - 1) {
                binding.viewPager.setCurrentItem(nextItem, true)
                if (nextItem==1){
                    binding.root.background = ContextCompat.getDrawable(this, R.drawable.background2)
                }
                else if (nextItem==2){
                    binding.root.background = ContextCompat.getDrawable(this, R.drawable.background3)
                    binding.btn.text = getString(R.string.lets_go)
                }
            }
        }
    }
}