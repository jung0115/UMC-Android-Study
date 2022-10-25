package com.bicontest.umc_week5

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bicontest.umc_week5.databinding.ItemRecyclerSwitchBinding

class SwitchAdapter(private val context: Context) :
    RecyclerView.Adapter<SwitchAdapter.SwitchViewHolder>(){

    var datas = mutableListOf<SwitchData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            SwitchAdapter.SwitchViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_switch, parent, false)

        return SwitchViewHolder(ItemRecyclerSwitchBinding.bind(view))
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: SwitchAdapter.SwitchViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class SwitchViewHolder(val binding: ItemRecyclerSwitchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SwitchData) {
            binding.switchName.text = item.name
            binding.switchContent.text = item.content
        }
    }
}