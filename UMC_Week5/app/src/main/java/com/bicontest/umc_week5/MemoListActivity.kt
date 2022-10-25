package com.bicontest.umc_week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bicontest.umc_week5.databinding.ActivityMemoListBinding

class MemoListActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemoListBinding // viewBinding

    lateinit var memoAdapter: MemoAdapter
    val datas = mutableListOf<MemoData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityMemoListBinding.inflate(layoutInflater);
        setContentView(viewBinding.root)

        viewBinding.memoBtn.setOnClickListener {
            // MemoWriteActivity로 데이터 전달
            val intent = Intent(this, MemoWriteActivity::class.java)
            startActivity(intent)
        }

        // MemoWriteActivity에서 전달된 데이터 받아오기
        val memoWriteIntent = intent
        val mMemoContent : String = memoWriteIntent.getStringExtra("memoText").toString()

        initSwitchRecycler()
        if(mMemoContent != "") addItem(mMemoContent)
    }

    private fun initSwitchRecycler() {
        memoAdapter = MemoAdapter(this)
        viewBinding.recyclerviewSwitch.adapter = memoAdapter

        memoAdapter.datas = datas
        memoAdapter.notifyDataSetChanged()
    }

    private fun addItem(mMemoText : String) {
        datas.apply {
            add(MemoData(memoText = mMemoText))
        }
    }
}