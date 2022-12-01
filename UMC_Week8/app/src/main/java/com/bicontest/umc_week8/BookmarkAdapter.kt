package com.bicontest.umc_week8

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bicontest.umc_week8.databinding.ItemRecyclerBookmarkBinding
import com.bicontest.umc_week8.db_entity.MemoDataEntity

class BookmarkAdapter(private val context: Context):
    RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder>() {

    var datas = mutableListOf<MemoDataEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            BookmarkAdapter.BookmarkViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_bookmark, parent, false)

        return BookmarkViewHolder(ItemRecyclerBookmarkBinding.bind(view))
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: BookmarkAdapter.BookmarkViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class BookmarkViewHolder(val binding: ItemRecyclerBookmarkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MemoDataEntity) {
            binding.memoText.text = item.memo_text
        }
    }
}