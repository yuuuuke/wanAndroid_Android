package com.yuuuuke.wanandroid.adapter

import android.os.Bundle
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.model.ArticleBean
import com.yuuuuke.wanandroid.utils.toHtml
import com.yuuuuke.wanandroid.widget.CollectView

/**
 * description:首页文章列表适配器
 *
 * @author zwp
 * @since 2021/3/11
 */
class ArticleAdapter(list:MutableList<ArticleBean>?) :
    BaseMultiItemQuickAdapter<ArticleBean, BaseViewHolder>(), LoadMoreModule {

    private val Ariticle = 0
    private val Project = 1
    private var showTag = true

    private var collectAction: (item: ArticleBean, v: CollectView, position: Int) -> Unit =
        { _: ArticleBean, _: CollectView, _: Int -> }

    constructor(list:MutableList<ArticleBean>,showTag:Boolean):this(list){
        this.showTag = showTag
    }

    init {
        addItemType(Ariticle,R.layout.layout_article_item)
        addItemType(Project,R.layout.layout_project_item)
    }

    override fun convert(holder: BaseViewHolder, item: ArticleBean) {

        if(item.itemType == Ariticle){
            //文章
            item.run {
                holder.setText(
                    R.id.item_home_author,
                    if (author.isNotEmpty()) author else shareUser
                )
                holder.setText(R.id.item_home_content, title.toHtml())
                holder.setText(R.id.item_home_type2, "$superChapterName·$chapterName".toHtml())
                holder.setText(R.id.item_home_date, niceDate)
                holder.getView<CollectView>(R.id.item_home_collect).isCollected = collect
                if (showTag) {
                    //展示标签
                    holder.setGone(R.id.item_home_new, !fresh)
                    holder.setGone(R.id.item_home_top, type != 1)
                    if (tags.isNotEmpty()) {
                        holder.setGone(R.id.item_home_type1, false)
                        holder.setText(R.id.item_home_type1, tags[0].name)
                    } else {
                        holder.setGone(R.id.item_home_type1, true)
                    }
                } else {
                    //隐藏所有标签
                    holder.setGone(R.id.item_home_top, true)
                    holder.setGone(R.id.item_home_type1, true)
                    holder.setGone(R.id.item_home_new, true)
                }
            }
            holder.getView<CollectView>(R.id.item_home_collect).onClick = {
                collectAction(item,it,holder.adapterPosition)
            }
        }else{
            //项目
            //项目布局的赋值
            item.run {
                holder.setText(
                    R.id.item_project_author,
                    if (author.isNotEmpty()) author else shareUser
                )
                holder.setText(R.id.item_project_title, title.toHtml())
                holder.setText(R.id.item_project_content, desc.toHtml())
                holder.setText(
                    R.id.item_project_type,
                    "$superChapterName·$chapterName".toHtml()
                )
                holder.setText(R.id.item_project_date, niceDate)
                if (showTag) {
                    //展示标签
                    holder.setGone(R.id.item_project_new, !fresh)
                    holder.setGone(R.id.item_project_top, type != 1)
                    if (tags.isNotEmpty()) {
                        holder.setGone(R.id.item_project_type1, false)
                        holder.setText(R.id.item_project_type1, tags[0].name)
                    } else {
                        holder.setGone(R.id.item_project_type1, true)
                    }
                } else {
                    //隐藏所有标签
                    holder.setGone(R.id.item_project_top, true)
                    holder.setGone(R.id.item_project_type1, true)
                    holder.setGone(R.id.item_project_new, true)
                }
                holder.getView<CollectView>(R.id.item_project_collect).isCollected = collect
                Glide.with(context).load(envelopePic)
                    .transition(DrawableTransitionOptions.withCrossFade(500))
                    .into(holder.getView(R.id.item_project_imageview))
            }
            holder.getView<CollectView>(R.id.item_project_collect).onClick = {
                collectAction(item,it,holder.adapterPosition)
            }
        }

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("TITLE", item.title)
            bundle.putString("URL", item.link)
            holder.itemView.findNavController().navigate(R.id.home_to_webView,bundle)
        }
    }
}