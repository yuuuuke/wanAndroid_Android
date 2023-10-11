package com.yuuuuke.wanandroid.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.model.WxGroupBean

class WxGroupAdapter : Adapter<WxGroupAdapter.MyHolder>() {

    private val mData = ArrayList<WxGroupBean>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data:List<WxGroupBean>){
        mData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_wx_group_item, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.setData(mData[position])
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val text = itemView.findViewById<TextView>(R.id.tv_group_name)
        fun setData(data:WxGroupBean){
            text.text = data.name
            text.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("ID", data.id)
                bundle.putString("NAME", data.name)
                it.findNavController().navigate(R.id.action_homeFragment_to_wxArticleDetailFragment,bundle)
            }
        }
    }
}