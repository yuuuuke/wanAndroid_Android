package com.yuuuuke.wanandroid.net

import com.yuuuuke.wanandroid.base.BaseBean
import com.yuuuuke.wanandroid.model.ArticleBean
import com.yuuuuke.wanandroid.model.PagerBean
import retrofit2.http.GET
import retrofit2.http.Path

interface CollectNetService {

    @GET("lg/collect/list/{page}/json")
    fun getAllCollectData(
        @Path("page") page: Int
    ): BaseBean<PagerBean<ArrayList<ArticleBean>>>
}