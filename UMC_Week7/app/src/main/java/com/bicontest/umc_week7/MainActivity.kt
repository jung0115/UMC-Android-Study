package com.bicontest.umc_week7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View

import com.bicontest.umc_week7.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding //viewBinding

    var totalTime: Int = 0      // 남은 시간
    var start: Boolean = false  // 타이머 시작 유무

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // Handler 생성
        val handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                if(totalTime == 0) { // 시간이 0이 되면 종료
                    viewBinding.timerStopBtn.visibility = View.GONE
                    viewBinding.timerResetBtn.visibility = View.VISIBLE
                    viewBinding.timeShowTextview.text = "타이머 종료"

                    start = false
                }
                else {
                    val minute = String.format("%02d", totalTime / 60) // 분
                    val second = String.format("%02d", totalTime % 60) // 초
                    viewBinding.timeShowTextview.text = "$minute:$second"
                }
            }

        }

        // 시작 버튼 클릭 시
        viewBinding.timerStartBtn.setOnClickListener {
            if(start == false) {3
                start = true

                // total time 초기화
                totalTime = viewBinding.timeInputEdittext.text.toString().toInt()
                viewBinding.timeInputEdittext.text = null
                viewBinding.timeInputEdittext.visibility = View.GONE

                // 화면에 남은 시간 표시
                viewBinding.timeShowTextview.visibility = View.VISIBLE
                val minute = String.format("%02d", totalTime / 60) // 분
                val second = String.format("%02d", totalTime % 60) // 초
                viewBinding.timeShowTextview.text = "$minute:$second"

                // 시작 버튼 숨기고 종료 버튼 보이기
                viewBinding.timerStartBtn.visibility = View.GONE
                viewBinding.timerStopBtn.visibility = View.VISIBLE

                // 스레드 생성
                thread(start = true) {
                    while(start) {
                        Thread.sleep(1000) // 1초 지연
                        if(start) {
                            totalTime -= 1 // 시간 줄어듦
                            handler?.sendEmptyMessage(0)
                        }
                    }
                }
            }
        }

        // 종료 버튼 클릭 시
        viewBinding.timerStopBtn.setOnClickListener {
            start = false
            totalTime = 0

            // 시작 버튼 보이고 종료 버튼 숨기기
            viewBinding.timerStartBtn.visibility = View.VISIBLE
            viewBinding.timerStopBtn.visibility = View.GONE

            // 시간 입력창 보이고 남은 시간 숨기기
            viewBinding.timeInputEdittext.visibility = View.VISIBLE
            viewBinding.timeShowTextview.visibility = View.GONE
        }

        // 초기화 버튼 클릭 시
        viewBinding.timerResetBtn.setOnClickListener {

            // 시작 버튼 보이고 초기화 버튼 숨기기
            viewBinding.timerStartBtn.visibility = View.VISIBLE
            viewBinding.timerResetBtn.visibility = View.GONE

            // 시간 입력창 보이고 남은 시간 숨기기
            viewBinding.timeInputEdittext.visibility = View.VISIBLE
            viewBinding.timeShowTextview.visibility = View.GONE
        }
    }
}