package com.bicontest.umc_week9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bicontest.umc_week9.databinding.ActivityKakaoLoginBinding
import com.bicontest.umc_week9.databinding.ActivityLoginSuccessBinding

class LoginSuccessActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLoginSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityLoginSuccessBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}