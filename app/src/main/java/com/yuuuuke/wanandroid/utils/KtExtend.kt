package com.yuuuuke.wanandroid.utils

import android.text.Html
import android.text.Spanned

/**
 * description:扩展函数
 *
 * @author zwp
 * @since 2021/5/20
 */

fun String.toHtml(flag: Int = Html.FROM_HTML_MODE_LEGACY): Spanned {
    return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        Html.fromHtml(this, flag)
    } else {
        Html.fromHtml(this)
    }
}