package com.yuuuuke.wanandroid.model

import java.io.Serializable

/**
 * description:置顶文章
 *
 * @author zwp
 * @since 2021/3/10
 */
data class HotArticleBean(
    var courseId: Int,
    var id: Int,
    var name: String,
    var order: Int,
    var parentChapterId: Int,
    var userControlSetTop: Boolean,
    var visible: Int,
    var children: List<HotArticleBean>
) : Serializable