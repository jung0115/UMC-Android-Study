package com.bicontest.umc_week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bicontest.umc_week3.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMain2Binding // viewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityMain2Binding.inflate(layoutInflater);
        setContentView(viewBinding.root)

        // MainActivity에서 전달된 데이터 받아오기
        val secondIntent = intent
        viewBinding.activity2Textview.text = secondIntent.getStringExtra("umcText")

        // activity3으로 이동하는 버튼 클릭 시
        viewBinding.goActivity3Btn.setOnClickListener {
            // MainActivity3으로 이동
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}