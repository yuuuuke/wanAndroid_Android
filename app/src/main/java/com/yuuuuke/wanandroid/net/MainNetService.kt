package com.yuuuuke.wanandroid.net

import com.yuuuuke.wanandroid.Const
import com.yuuuuke.wanandroid.base.BaseBean
import com.yuuuuke.wanandroid.model.BannerDataBean
import com.yuuuuke.wanandroid.model.ArticleBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * description:接口类
 *
 * @author zwp
 * @since 2021/3/10
 */
interface MainNetService {

    @GET(Const.BASE_URL + "/banner/json")
    fun getBanner(): BaseBean<BannerDataBean>

    @GET(Const.BASE_URL + "/article/top/json")
    fun getHotArticle(): BaseBean<List<ArticleBean>>

    @GET(Const.BASE_URL + "/article/list/{page}/json")
    fun getMainArticlePage(@Path("page") page: Int): BaseBean<List<ArticleBean>>
}