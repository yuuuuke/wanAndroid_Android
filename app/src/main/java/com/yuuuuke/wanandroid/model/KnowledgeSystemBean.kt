package com.yuuuuke.wanandroid.model

/**
 * description:知识体系
 *
 * @author zwp
 * @since 2021/3/11
 */
data class KnowledgeSystemBean(
    var courseId: Int,
    var id: Int,
    var name: String,
    var order: Int,
    var parentChapterId: Int,
    var userControlSetTop: Boolean,
    var visible: Int,
    var children: List<ArticleBean>
)