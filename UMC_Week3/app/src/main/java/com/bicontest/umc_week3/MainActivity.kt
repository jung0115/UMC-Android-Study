package com.bicontest.umc_week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bicontest.umc_week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding // viewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(viewBinding.root)

        // 버튼 클릭 시
        viewBinding.activity1Btn.setOnClickListener {
            // editText에 입력된 text를 가져옴
            var inputText = viewBinding.activity1Edittext.text.toString()

            // MainActivity2로 데이터 전달
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("umcText", inputText)
            startActivity(intent)
        }
    }
}