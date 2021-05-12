package com.yuuuuke.wanandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.model.ArticleBean
import com.yuuuuke.wanandroid.model.BannerDataBean
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.MainNetService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * description:main fragment view model
 *
 * @author zwp
 * @since 2021/3/10
 */
class MainFragmentViewModel : BaseViewModel() {

    lateinit var bannerData: MutableLiveData<BannerDataBean>

    lateinit var topArticle: MutableLiveData<ArrayList<ArticleBean>>

    lateinit var articleData: MutableLiveData<ArrayList<ArticleBean>>

    fun getBanner() {
        requestData({
            BaseHttpHelper.create<MainNetService>().getBanner()
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

    fun getTopArticle() {
        requestData({
            BaseHttpHelper.create<MainNetService>().getHotArticle()
        }, {
            topArticle.value = it.data
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
            BaseHttpHelper.create<MainNetService>().getMainArticlePage(page)
        }, {
            if (page == 0) {
                //第一页
                articleData.value = it.data
            } else {
                articleData.value?.addAll(it.data)
            }
        }, {
            if (it.code == -1) {
                commonUiChange.showToast.value = "数据请求失败，请稍后重试"
            } else {
                commonUiChange.showToast.value = it.message
            }
        })
    }
}