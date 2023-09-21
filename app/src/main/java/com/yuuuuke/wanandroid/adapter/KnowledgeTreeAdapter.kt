package com.yuuuuke.wanandroid.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.model.KnowledgeSystemBean
import com.yuuuuke.wanandroid.model.ProjectDetail
import com.yuuuuke.wanandroid.widget.AutoWrapGroupLayout

class KnowledgeTreeAdapter: BaseQuickAdapter<KnowledgeSystemBean, BaseViewHolder>(R.layout.layout_knowledge_group_item),LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: KnowledgeSystemBean) {
        holder.setText(R.id.father_title,item.name)
        val view = holder.getView<AutoWrapGroupLayout>(R.id.group_layout)
        view.setData(item.children)
    }
}