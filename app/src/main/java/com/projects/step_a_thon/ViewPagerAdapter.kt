package com.projects.step_a_thon

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment : FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FirstFragment.newInstance(0)
            1 -> FirstFragment.newInstance(1)
            else -> FirstFragment.newInstance(2)
        }
    }
}