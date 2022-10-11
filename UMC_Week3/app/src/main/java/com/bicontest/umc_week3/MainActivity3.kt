package com.bicontest.umc_week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bicontest.umc_week3.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMain3Binding // viewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityMain3Binding.inflate(layoutInflater);
        setContentView(viewBinding.root)

        // 새 객체 생성
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        // Fragment를 Container에 할당 - 처음에는 firstFragment를 보여주도록
        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id, firstFragment)
            .commitAllowingStateLoss()

        // Fragment1 버튼을 누르면 firstFragment 보여주기
        viewBinding.gotoFragment1Btn.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.containerFragment.id, firstFragment)
                .commitAllowingStateLoss()
        }

        // Fragment2 버튼을 누르면 secondFragment 보여주기
        viewBinding.gotoFragment2Btn.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.containerFragment.id, secondFragment)
                .commitAllowingStateLoss()
        }
    }
}