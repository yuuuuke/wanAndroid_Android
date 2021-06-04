package com.yuuuuke.wanandroid.model

import java.io.Serializable

/**
 * description:首页返回的数据格式
 *
 * @author zwp
 * @since 2021/6/1
 */
data class PagerBean<T>(
    var datas: T,
    var curPage: Int,
    var offset: Int,
    var over: Boolean,
    var pageCount: Int,
    var size: Int,
    var total: Int
):Serializable