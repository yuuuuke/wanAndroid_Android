package com.yuuuuke.wanandroid.net

import com.yuuuuke.wanandroid.base.BaseBean
import com.yuuuuke.wanandroid.model.ArticleBean
import com.yuuuuke.wanandroid.model.PagerBean
import com.yuuuuke.wanandroid.model.WxGroupBean
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WxArticleService {

    @GET("/wxarticle/chapters/json")
    suspend fun getWxGroup(): BaseBean<ArrayList<WxGroupBean>>

    @GET("/wxarticle/list/{id}/{page}/json")
    suspend fun getWxArticle(@Path("id") id: Int, @Path("page") page: Int):BaseBean<PagerBean<ArrayList<ArticleBean>>>

    @GET("/wxarticle/list/{id}/{page}/json")
    suspend fun searchArticle(@Path("id") id: Int, @Path("page") page: Int, @Query("k") key: String):BaseBean<PagerBean<ArrayList<ArticleBean>>>
}