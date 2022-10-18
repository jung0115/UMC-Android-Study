package com.bicontest.umc_week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bicontest.umc_week4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding // viewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivitySecondBinding.inflate(layoutInflater);
        setContentView(viewBinding.root)

        // MainActivity에서 전달된 데이터 받아오기
        val secondIntent = intent
        viewBinding.memoTextview.text = secondIntent.getStringExtra("memoText")

    }
}