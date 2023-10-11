package com.yuuuuke.wanandroid.adapter

import android.content.Intent
import android.net.Uri
import android.util.Log
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.model.ArticleBean

class WxArticleDetailAdapter:BaseQuickAdapter<ArticleBean,BaseViewHolder>(R.layout.layout_article_item),LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: ArticleBean) {
        holder.setText(R.id.item_home_content,item.title)
        holder.setText(R.id.item_home_date, item.niceDate)
        holder.setText(
            R.id.item_home_author,
            item.author.ifEmpty { item.shareUser }
        )
        holder.setGone(R.id.item_home_type2,true)
        holder.setGone(R.id.item_home_top,true)
        holder.setGone(R.id.item_home_new,true)
        holder.setGone(R.id.item_home_type1,true)

        holder.itemView.setOnClickListener {
            val webpage = Uri.parse(item.link)
            val intent = Intent(Intent.ACTION_VIEW, webpage);
            context.startActivity(intent);
        }
    }
}