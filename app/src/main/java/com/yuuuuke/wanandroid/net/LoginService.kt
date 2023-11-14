package com.yuuuuke.wanandroid.net

import com.yuuuuke.wanandroid.base.BaseBean
import com.yuuuuke.wanandroid.model.UserBean
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginService {

    @POST("/user/login")
    @FormUrlEncoded
    suspend fun login(@Field("username") username: String, @Field("password") password: String):BaseBean<UserBean>

    @POST("/user/register")
    @FormUrlEncoded
    suspend fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ):BaseBean<Any>

    @GET
    suspend fun logout()

}