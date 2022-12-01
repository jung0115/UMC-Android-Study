package com.bicontest.umc_week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bicontest.umc_week8.databinding.ActivityBookmarkBinding
import com.bicontest.umc_week8.db_entity.MemoDataEntity

class BookmarkActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityBookmarkBinding // viewBinding

    // Room DB 세팅
    private var db: AppDatabase? = null

    lateinit var bookmarkAdapter: BookmarkAdapter
    val datas = mutableListOf<MemoDataEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 초기화
        viewBinding = ActivityBookmarkBinding.inflate(layoutInflater);
        setContentView(viewBinding.root)

        // db 세팅
        db = AppDatabase.getInstance(this)

        // recyclerview 초기화
        initBookmarkRecycler()

        // 저장된 메모 데이터 불러와서 추가
        val memoDatas = db!!.memoDataDao().getAllMemoData()
        if(memoDatas.isNotEmpty()) {
            for(i: Int in 0..(memoDatas.size - 1)) {
                val isBookmark = MyApplication.prefs.getString(memoDatas[i].memo_uid.toString(), "")

                // 즐겨찾기로 체크된 메모인 경우
                if(isBookmark.toBoolean()) {
                    datas.add(memoDatas[i])
                }
            }
        }

        bookmarkAdapter.notifyDataSetChanged()
    }

    private fun initBookmarkRecycler() {
        bookmarkAdapter  = BookmarkAdapter(this)

        viewBinding.recyclerviewBookmark.layoutManager = LinearLayoutManager(this)
        viewBinding.recyclerviewBookmark.adapter = bookmarkAdapter
        bookmarkAdapter.datas = datas
    }
}