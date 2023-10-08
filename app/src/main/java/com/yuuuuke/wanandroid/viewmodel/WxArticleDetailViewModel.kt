package com.yuuuuke.wanandroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.model.ArticleBean
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.WxArticleService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WxArticleDetailViewModel : BaseViewModel() {

    private val state = UiState()
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
            state.detailData.addAll(it.data.datas)
            mPage++
            stateFlow.emit(state)
        }, {

        })
    }

    private fun searchByKey(id: Int, key: String) {
        requestData({
            service.searchArticle(id, mSearchPage, key)
        }, {
            state.searchResultData.addAll(it.data.datas)
            mSearchPage++
            stateFlow.emit(state)
        }, {

        })
    }

    private fun changeMode(b: Boolean) {
        state.searchMode = b
        viewModelScope.launch {
            stateFlow.emit(state)
        }
    }

    private fun clearResult() {
        state.searchResultData.clear()
        mSearchPage = 0
        viewModelScope.launch {
            stateFlow.emit(state)
        }
    }
}

data class UiState(
    var searchMode: Boolean = false,
    val detailData: ArrayList<ArticleBean> = ArrayList(),
    val searchResultData: ArrayList<ArticleBean> = ArrayList()
)

sealed class DetailAction {
    class GetDetailData(val id: Int) : DetailAction()
    class SearchByKey(val id: Int, val key: String) : DetailAction()
    class GoSearchMode(val b: Boolean) : DetailAction()
    object ClearResultData : DetailAction()
}