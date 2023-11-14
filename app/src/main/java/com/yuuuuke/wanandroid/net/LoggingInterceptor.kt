package com.yuuuuke.wanandroid.net

import com.yuuuuke.wanandroid.utils.KtLog
import okhttp3.Interceptor
import okhttp3.Response

/**
 * description:日志拦截器
 *
 * @author zwp
 * @since 2021/6/1
 */
class LoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        KtLog("请求的接口为：" + request.url().encodedPath())

        return chain.proceed(request)
    }
}