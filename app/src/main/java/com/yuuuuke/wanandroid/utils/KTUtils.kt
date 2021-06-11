package com.yuuuuke.wanandroid.utils

import android.util.TypedValue
import com.yuuuuke.wanandroid.MyApplication

/**
 * description:
 *
 * @author zwp
 * @since 2021/5/20
 */

fun KtLog(message:String){
    android.util.Log.v("zwp",message)
}


fun dp2px(dp: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        MyApplication.instance.resources.displayMetrics
    ).toInt()
}