package com.yuuuuke.wanandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.model.ProjectDetail

class ProjectAdapter :
    BaseQuickAdapter<ProjectDetail, BaseViewHolder>(R.layout.layout_project_item), LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: ProjectDetail) {
        // 项目图片
        Glide.with(context).load(item.envelopePic).into(holder.getView<ImageView>(R.id.item_project_imageview))
        holder.setText(R.id.item_project_author,item.chapterName)
        holder.setText(R.id.item_project_date,item.niceDate)
        holder.setGone(R.id.item_project_top,true)
        holder.setGone(R.id.item_project_new,true)
        holder.setGone(R.id.item_project_type1,true)
        holder.setText(R.id.item_project_title,item.title)
        holder.setText(R.id.item_project_content,item.desc)
        holder.setText(R.id.item_project_type,item.author)
    }
}