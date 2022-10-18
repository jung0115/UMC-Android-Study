package com.bicontest.umc_week4

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.bicontest.umc_week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding // viewBinding
    private var memoSave : String = ""                    // onStop 시 메모 내용을 저장해둘 전역변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 메모 작성 버튼 클릭 시
        viewBinding.memoBtn.setOnClickListener {
            // editText에 입력된 text를 가져옴
            var inputText = viewBinding.memoEdittext.text.toString()

            // MainActivity2로 데이터 전달
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("memoText", inputText)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()

        memoSave = viewBinding.memoEdittext.text.toString() // editText의 내용을 memoSave에 저장
        viewBinding.memoEdittext.setText(null)              // editText 내용 비우기
    }

    override fun onRestart() {
        super.onRestart()

        var builder = AlertDialog.Builder(this)
        builder.setTitle("앱 재실행")
        builder.setMessage("이어서 작성하시겠습니까?")
        //builder.setIcon(R.mipmap.ic_launcher)

        // 버튼 클릭시에 무슨 작업을 할 것인가!
        var listener = object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                when (p1) {
                    DialogInterface.BUTTON_POSITIVE ->
                        viewBinding.memoEdittext.setText(memoSave)
                    DialogInterface.BUTTON_NEUTRAL ->
                        memoSave = ""
                }
            }
        }

        builder.setPositiveButton("예", listener)
        builder.setNegativeButton("아니오", listener)

        builder.show()
    }
}