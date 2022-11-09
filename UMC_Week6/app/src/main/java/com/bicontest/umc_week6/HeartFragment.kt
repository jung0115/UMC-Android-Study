package com.bicontest.umc_week6

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.bicontest.umc_week6.databinding.FragmentHeartBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HeartFragment : Fragment() {
    private lateinit var viewBinding : FragmentHeartBinding

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    companion object {
        fun newInstance(): HeartFragment = HeartFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHeartBinding.inflate(layoutInflater);

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout = viewBinding.tlNavigationView
        viewPager = viewBinding.vpViewpagerMain

        val adapter = ViewPager2Adapter(this)
        viewPager.adapter = adapter

        val tabName = arrayOf<String>("PINK", "GREEN", "BLUE")

        //슬라이드로 이동했을 때, 탭이 같이 변경되도록
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabName[position].toString()
        }.attach()

        //탭이 선택되었을 때, 뷰페이저가 같이 변경되도록
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

}