package com.bicontest.umc_week8

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bicontest.umc_week8.databinding.ItemRecyclerMemoBinding
import com.bicontest.umc_week8.db_entity.MemoDataEntity

class MemoAdapter (
    private val context: Context,
    val onClickDeleteMemo: (memo: MemoDataEntity) -> Unit // 메모 클릭 시 onClickDeleteMemo 실행
    ) :
    RecyclerView.Adapter<MemoAdapter.MemoViewHolder>(){

    var datas = mutableListOf<MemoDataEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            MemoAdapter.MemoViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_memo, parent, false)

        return MemoViewHolder(ItemRecyclerMemoBinding.bind(view))
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: MemoAdapter.MemoViewHolder, position: Int) {
        holder.bind(datas[position])

    }

    inner class MemoViewHolder(val binding: ItemRecyclerMemoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MemoDataEntity) {
            binding.memoText.text = item.memo_text

            val isBookmark = MyApplication.prefs.getString(item.memo_uid.toString(), "")

            // 이전에 즐겨찾기로 체크했던 메모인 경우 체크박스 활성화
            if(isBookmark.toBoolean()) {
                binding.memoBookmark.isChecked = true
            }

            // 즐겨찾기 체크박스 선택 시
            binding.memoBookmark.setOnClickListener {
                if(binding.memoBookmark.isChecked) { // 체크한 경우
                    MyApplication.prefs.setString(item.memo_uid.toString(), "true") // 즐겨찾기 메모 표시
                }
                else { // 체크 해제
                    MyApplication.prefs.setString(item.memo_uid.toString(), "") // 저장해둔 데이터 삭제
                }
            }

            // 메모 삭제 버튼 클릭 시
            binding.memoDelete.setOnClickListener {
                onClickDeleteMemo.invoke(item) //삭제 함수 호출
            }
        }
    }
}