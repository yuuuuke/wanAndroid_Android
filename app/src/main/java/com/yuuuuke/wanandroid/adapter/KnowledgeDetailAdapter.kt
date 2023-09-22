package com.yuuuuke.wanandroid.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.model.ProjectDetail
import com.yuuuuke.wanandroid.navigation.NavHostFragment.findNavController

class KnowledgeDetailAdapter :
    BaseQuickAdapter<ProjectDetail, BaseViewHolder>(R.layout.layout_article_item), LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: ProjectDetail) {
        holder.setText(R.id.item_home_author, item.author)
        holder.setText(R.id.item_home_date, item.niceDate)
        holder.setText(R.id.item_home_content, item.title)
        holder.setText(R.id.item_home_type2, item.superChapterName)
        holder.setGone(R.id.item_home_top, true)
        holder.setGone(R.id.item_home_type1, true)
        holder.setGone(R.id.item_home_new, true)

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("TITLE", item.title)
            bundle.putString("URL", item.link)
            holder.itemView.findNavController().navigate(R.id.knowledgeDetail_to_webView,bundle)
        }
    }
}