package com.bicontest.umc_week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.bicontest.umc_week6.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding // viewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(binding.fragmentLayout.id, HomeFragment()).commit()
        // navigationBottomView 등록: 하단바 fragment id(bottom_navigation) 등록
        transitionNavigationBottomView(binding.bottomNavigation, supportFragmentManager)
    }

    // NavigationBottomView 화면 전환하는 함수.
    private fun transitionNavigationBottomView(bottomView: BottomNavigationView, fragmentManager: FragmentManager){
        bottomView.setOnItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.heart -> {
                    fragmentManager.beginTransaction().replace(binding.fragmentLayout.id, HeartFragment()).commit()
                }
                R.id.home -> {
                    fragmentManager.beginTransaction().replace(binding.fragmentLayout.id, HomeFragment()).commit()
                }
                R.id.star -> {
                    fragmentManager.beginTransaction().replace(binding.fragmentLayout.id, StarFragment()).commit()
                }
                else -> Log.d("test", "error") == 0
            }
            Log.d("test", "final") == 0
        }
    }
}