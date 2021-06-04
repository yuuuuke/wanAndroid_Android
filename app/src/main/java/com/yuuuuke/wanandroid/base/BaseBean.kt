package com.yuuuuke.wanandroid.base

import java.io.Serializable

/**
 * description:bean类基类
 *
 * @author zwp
 * @since 2021/3/10
 */
data class BaseBean<T>(
    var errorCode: Int,
    var errorMsg: String,
    var data: T
) : Serializable