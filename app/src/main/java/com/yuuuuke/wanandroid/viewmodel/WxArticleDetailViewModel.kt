package com.yuuuuke.wanandroid.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.model.ArticleBean
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.WxArticleService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WxArticleDetailViewModel : BaseViewModel() {

    private var state = UiState()
    private var mPage = 0
    private var mSearchPage = 0
    private val service: WxArticleService = BaseHttpHelper.create()

    val stateFlow = MutableStateFlow(state)

    fun dispatch(action: DetailAction) {
        when (action) {
            is DetailAction.GetDetailData -> getDetailData(action.id)
            is DetailAction.SearchByKey -> searchByKey(action.id, action.key)
            is DetailAction.GoSearchMode -> changeMode(action.b)
            is DetailAction.ClearResultData -> clearResult()
        }
    }

    private fun getDetailData(id: Int) {
        requestData({
            service.getWxArticle(id, mPage)
        }, {
            val list = ArrayList<ArticleBean>()
            list.addAll(state.detailData)
            if (it.data.over) {
                // 结束了
                state = state.copy(detailData = list.apply { addAll(it.data.datas) },allDataLoadFinished = true)
            } else {
                state = state.copy(detailData = list.apply { addAll(it.data.datas) },allDataLoadFinished = false)
                mPage++
            }

            stateFlow.emit(state)
        }, {

        })
    }

    private fun searchByKey(id: Int, key: String) {
        requestData({
            service.searchArticle(id, mSearchPage, key)
        }, {
            val list = ArrayList<ArticleBean>()
            list.addAll(state.searchResultData)
            if (it.data.over) {
                // 结束了
                state = state.copy(searchResultData = list.apply { addAll(it.data.datas) }, searchDataLoadFinish = true)
            } else {
                state = state.copy(searchResultData = list.apply { addAll(it.data.datas) },searchDataLoadFinish = false)
                mSearchPage++
            }
            stateFlow.emit(state)
        }, {

        })
    }

    private fun changeMode(b: Boolean) {
        state = state.copy(searchMode = b)
        viewModelScope.launch {
            stateFlow.emit(state)
        }
    }

    private fun clearResult() {
        state = state.copy(
            searchDataLoadFinish = false,
            searchResultData = ArrayList())
        mSearchPage = 0
        viewModelScope.launch {
            stateFlow.emit(state)
        }
    }
}

data class UiState(
    val allDataLoadFinished: Boolean = false,
    val searchDataLoadFinish: Boolean = false,
    val searchMode: Boolean = false,
    val detailData: ArrayList<ArticleBean> = ArrayList(),
    val searchResultData: ArrayList<ArticleBean> = ArrayList(),
)

sealed class DetailAction {
    class GetDetailData(val id: Int) : DetailAction()
    class SearchByKey(val id: Int, val key: String) : DetailAction()
    class GoSearchMode(val b: Boolean) : DetailAction()
    object ClearResultData : DetailAction()
}