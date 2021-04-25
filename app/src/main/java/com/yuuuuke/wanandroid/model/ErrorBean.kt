package com.yuuuuke.wanandroid.model

/**
 * description:错误
 *
 * @author zwp
 * @since 2021/4/25
 */
data class ErrorBean(
    var code: Int,
    var message: String,
    var error: Throwable?
) {
    constructor(error: Throwable) : this(-1, "", error)
}