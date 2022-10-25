package com.bicontest.umc_week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bicontest.umc_week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding  // viewBinding

    lateinit var switchAdapter: SwitchAdapter
    val datas = mutableListOf<SwitchData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initSwitchRecycler()
    }

    private fun initSwitchRecycler() {
        switchAdapter = SwitchAdapter(this)
        viewBinding.recyclerviewSwitch.adapter = switchAdapter

        datas.apply {
            add(SwitchData(name = "Sally", content = "UMC Android"))
            add(SwitchData(name = "김철수", content = "철수는 김 씨이다."))
            add(SwitchData(name = "홍길동", content = "동해번쩍 서해번쩍"))
            add(SwitchData(name = "성춘향", content = "춘향전의 주인공"))
            add(SwitchData(name = "김아무개", content = "아무개 씨는 김 씨이다."))
            add(SwitchData(name = "김아무개", content = "아무개 씨는 김 씨이다."))
            add(SwitchData(name = "김아무개", content = "아무개 씨는 김 씨이다."))
            add(SwitchData(name = "김아무개", content = "아무개 씨는 김 씨이다."))
            add(SwitchData(name = "김아무개", content = "아무개 씨는 김 씨이다."))
            add(SwitchData(name = "김아무개", content = "아무개 씨는 김 씨이다."))
            add(SwitchData(name = "김아무개", content = "아무개 씨는 김 씨이다."))
            add(SwitchData(name = "김아무개", content = "아무개 씨는 김 씨이다."))
            add(SwitchData(name = "김아무개", content = "아무개 씨는 김 씨이다."))

            switchAdapter.datas = datas
            switchAdapter.notifyDataSetChanged()
        }
    }
}