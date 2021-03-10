package com.yuuuuke.wanandroid.model

import java.io.Serializable

/**
 * description:横幅数据
 *
 * @author zwp
 * @since 2021/3/10
 */
data class BannerDataBean(
    var desc: String,
    var id: Int,
    var imagePath: String,
    var isVisible: Int,
    var order: Int,
    var title: String,
    var type: Int,
    var url: String
) : Serializable