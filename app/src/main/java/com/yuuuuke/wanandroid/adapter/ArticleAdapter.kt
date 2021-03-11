package com.yuuuuke.wanandroid.adapter

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.model.ArticleBean
import kotlinx.android.synthetic.main.layout_article_item.view.*

/**
 * description:首页文章列表适配器
 *
 * @author zwp
 * @since 2021/3/11
 */
class ArticleAdapter() :
    BaseQuickAdapter<ArticleBean, ArticleAdapter.ArticleViewHolder>(R.layout.layout_article_item) {

    override fun convert(holder: ArticleViewHolder, item: ArticleBean) {
        holder.tvAuthor.text = item.author
        holder.tvContent.text = item.desc
//        holder.tvTime
    }

    inner class ArticleViewHolder(view: View) : BaseViewHolder(view) {

        val tvAuthor by lazy {
            view.item_home_author
        }
        val tvLabelTop by lazy {
            view.item_home_top
        }
        val tvLabelNew by lazy {
            view.item_home_new
        }
        val tvTime by lazy {
            view.item_home_date
        }
        val tvType1 by lazy {
            view.item_home_type1
        }
        val tvContent by lazy {
            view.item_home_content
        }
        val tvType2 by lazy {
            view.item_home_type2
        }
        val btnCollect by lazy {
            view.item_home_collect
        }
    }
}