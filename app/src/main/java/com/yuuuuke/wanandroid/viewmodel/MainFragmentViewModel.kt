package com.yuuuuke.wanandroid.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.model.ArticleBean
import com.yuuuuke.wanandroid.model.BannerDataBean
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.MainNetService
import com.yuuuuke.wanandroid.utils.KtLog
import kotlinx.coroutines.*

/**
 * description:main fragment view model
 *
 * @author zwp
 * @since 2021/3/10
 */
class MainFragmentViewModel : BaseViewModel() {

    private val service: MainNetService by lazy {
        BaseHttpHelper.create<MainNetService>()
    }

    val bannerData: MutableLiveData<BannerDataBean> by lazy {
        MutableLiveData<BannerDataBean>()
    }

    val topArticle: MutableLiveData<ArrayList<ArticleBean>> by lazy {
        MutableLiveData<ArrayList<ArticleBean>>()
    }

    val articleData: MutableLiveData<ArrayList<ArticleBean>> by lazy {
        MutableLiveData<ArrayList<ArticleBean>>()
    }

    fun getBanner() {
        requestData({
            service.getBanner()
        }, {
            bannerData.value = it.data
        }, {
            if (it.code == -1) {
                commonUiChange.showToast.value = "数据请求失败，请稍后重试"
            } else {
                commonUiChange.showToast.value = it.message
            }
        })
    }

    fun getAllArticle(page: Int) {
        requestData({
            if (page == 0) {
                //第一页内容，要把热门文章加上
                val deferred1 = async {
                    service.getHotArticle()
                }
                val deferred2 = async {
                    service.getMainArticlePage(page)
                }
                val hotData = deferred1.await()
                val data = deferred2.await()
                data.data.datas.addAll(0, hotData.data)
                data
            } else {
                //后面的内容
                KtLog("加载更多")
                service.getMainArticlePage(page)
            }
        }, {
            //第一页
            articleData.value = it.data.datas
        }, {
            if (it.code == -1) {
                commonUiChange.showToast.value = "数据请求失败，请稍后重试"
            } else {
                commonUiChange.showToast.value = it.message
            }
        })
    }
}