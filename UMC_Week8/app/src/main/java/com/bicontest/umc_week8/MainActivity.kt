package com.bicontest.umc_week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.bicontest.umc_week8.databinding.ActivityMainBinding
import com.bicontest.umc_week8.db_entity.MemoDataEntity

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding // viewBinding

    // Room DB 세팅
    private var db: AppDatabase? = null

    lateinit var memoAdapter: MemoAdapter
    val datas = mutableListOf<MemoDataEntity>()

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(viewBinding.root)

        // db 세팅
        db = AppDatabase.getInstance(this)

        // recyclerview 초기화
        initMemoRecycler()

        // 저장된 메모 데이터 불러와서 추가
        val memoDatas = db!!.memoDataDao().getAllMemoData()
        if(memoDatas.isNotEmpty()) {
            datas.addAll(memoDatas)
        }

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

        // 즐겨찾기 버튼 클릭 시
        viewBinding.bookmarkBtn.setOnClickListener {
            // 즐겨찾기 페이지로 이동
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initMemoRecycler() {
        memoAdapter  = MemoAdapter(
            this,
            onClickDeleteMemo = {
                deleteItem(it)
            }
        )

        viewBinding.recyclerviewMemo.layoutManager = LinearLayoutManager(this)
        viewBinding.recyclerviewMemo.adapter = memoAdapter
        memoAdapter.datas = datas
        //memoAdapter.notifyDataSetChanged()
    }

    // 메모 추가
    private fun addItem(mMemoText : String) {
        // Room DB에 추가
        db?.memoDataDao()?.insertMemoData(MemoDataEntity(0, mMemoText))
        val memoDatas = db!!.memoDataDao().getAllMemoData()

        // Recyclerview에 추가
        datas.apply {
            add(memoDatas[memoDatas.size-1])
            memoAdapter.notifyDataSetChanged()
        }
    }

    // 메모 삭제
    private fun deleteItem(mMemo : MemoDataEntity) {
        // Recyclerview에서 삭제
        datas.apply {
            remove(mMemo)
            memoAdapter.notifyDataSetChanged()
        }

        // Room DB에서 삭제
        db?.memoDataDao()?.deleteMemoData(mMemo)
    }
}