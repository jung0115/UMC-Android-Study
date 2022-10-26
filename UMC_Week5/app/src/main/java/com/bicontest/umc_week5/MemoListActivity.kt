package com.bicontest.umc_week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.bicontest.umc_week5.databinding.ActivityMemoListBinding

class MemoListActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemoListBinding // viewBinding

    lateinit var memoAdapter: MemoAdapter
    val datas = mutableListOf<MemoData>()

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityMemoListBinding.inflate(layoutInflater);
        setContentView(viewBinding.root)

        initSwitchRecycler()

        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result: ActivityResult ->
            //Toast.makeText(this, "check", Toast.LENGTH_SHORT).show()
            if(result.resultCode == RESULT_OK){
                val mMemoContent : String = result.data?.getStringExtra("memoText").toString()
                addItem(mMemoContent)
                //Toast.makeText(this, mMemoContent, Toast.LENGTH_SHORT).show()
            }
        }

        // 메모 작성 버튼 클릭 시
        viewBinding.memoBtn.setOnClickListener {
            // 메모 작성 페이지로 이동
            val intent = Intent(this, MemoWriteActivity::class.java)
            activityResultLauncher.launch(intent)
        }
    }

    private fun initSwitchRecycler() {
        memoAdapter  = MemoAdapter(
            this,
            onClickDeleteMemo = {
                deleteItem(it)
            }
        )

        viewBinding.recyclerviewSwitch.layoutManager = LinearLayoutManager(this)
        viewBinding.recyclerviewSwitch.adapter = memoAdapter
        memoAdapter.datas = datas
        //memoAdapter.notifyDataSetChanged()
    }

    // 메모 추가
    private fun addItem(mMemoText : String) {
        datas.apply {
            add(MemoData(memoText = mMemoText))
            memoAdapter.notifyDataSetChanged()
        }
    }

    // 메모 삭제
    private fun deleteItem(mMemo : MemoData) {
        datas.apply {
            remove(mMemo)
            memoAdapter.notifyDataSetChanged()
        }
    }
}