package com.yuuuuke.wanandroid.net

import com.yuuuuke.wanandroid.utils.DataCenter
import okhttp3.Interceptor
import okhttp3.Response

class CommonParamsInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        DataCenter.user?.apply{
            builder.addHeader("Cookie","loginUserName=$username")
            builder.addHeader("Cookie","loginUserPassword=$password")
        }
        return chain.proceed(builder.build())
    }
}