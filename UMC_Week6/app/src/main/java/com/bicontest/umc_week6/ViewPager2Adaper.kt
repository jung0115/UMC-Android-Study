package com.bicontest.umc_week6

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_PAGES = 3

class ViewPager2Adapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PinkHeartFragment()
            1 -> GreenHeartFragment()
            2 -> BlueHeartFragment()
            else -> PinkHeartFragment()
        }
    }
}