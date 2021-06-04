package com.yuuuuke.wanandroid.net

import com.yuuuuke.wanandroid.Const
import com.yuuuuke.wanandroid.base.BaseBean
import com.yuuuuke.wanandroid.model.BannerDataBean
import com.yuuuuke.wanandroid.model.ArticleBean
import com.yuuuuke.wanandroid.model.PagerBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * description:接口类
 *
 * @author zwp
 * @since 2021/3/10
 */
interface MainNetService {

    @GET("/banner/json")
    suspend fun getBanner(): BaseBean<BannerDataBean>

    @GET("/article/top/json")
    suspend fun getHotArticle(): BaseBean<ArrayList<ArticleBean>>

    @GET("/article/list/{page}/json")
    suspend fun getMainArticlePage(@Path("page") page: Int): BaseBean<PagerBean<ArrayList<ArticleBean>>>
}