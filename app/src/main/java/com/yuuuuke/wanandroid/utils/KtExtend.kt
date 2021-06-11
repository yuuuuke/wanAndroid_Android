package com.yuuuuke.wanandroid.utils

import android.text.Html
import android.text.Spanned
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yuuuuke.wanandroid.R

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

//直接跳转
fun Fragment.nav(id: Int) {
    findNavController().navigate(id)
}

//先判断登录，再跳转
fun Fragment.navAfterLogin(id: Int) {
    DataCenter.user?.let{
        findNavController().navigate(id)
    }?:findNavController().navigate(R.id.loginFragment)
}