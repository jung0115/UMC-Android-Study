package com.bicontest.umc_week5

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bicontest.umc_week5.databinding.ItemRecyclerMemoBinding

class MemoAdapter (
    private val context: Context,
    val onClickDeleteMemo: (memo: MemoData) -> Unit // 메모 클릭 시 onClickDeleteMemo 실행
    ) :
    RecyclerView.Adapter<MemoAdapter.MemoViewHolder>(){

    var datas = mutableListOf<MemoData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            MemoAdapter.MemoViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_memo, parent, false)

        return MemoViewHolder(ItemRecyclerMemoBinding.bind(view))
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: MemoAdapter.MemoViewHolder, position: Int) {
        holder.bind(datas[position])

        // 메모 클릭 시
        holder.itemView.setOnClickListener {
            onClickDeleteMemo.invoke(datas[position]) //삭제 함수 호출
        }
    }

    inner class MemoViewHolder(val binding: ItemRecyclerMemoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MemoData) {
            binding.memoText.text = item.memoText
        }
    }
}