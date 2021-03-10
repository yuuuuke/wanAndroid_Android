package com.yuuuuke.wanandroid.net

import com.yuuuuke.wanandroid.base.BaseBean
import com.yuuuuke.wanandroid.model.BannerDataBean
import com.yuuuuke.wanandroid.model.HotArticleBean
import retrofit2.http.GET

/**
 * description:接口类
 *
 * @author zwp
 * @since 2021/3/10
 */
interface MainNetService {
    @GET("https://www.wanandroid.com/banner/json")
    fun getBanner(): BaseBean<BannerDataBean>

    @GET("https://www.wanandroid.com/tree/json")
    fun getHotArticle(): BaseBean<List<HotArticleBean>>
}