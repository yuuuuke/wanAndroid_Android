package com.yuuuuke.wanandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.model.WxGroupBean
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.WxArticleService

class WxArticleViewModel: BaseViewModel() {

    private val service:WxArticleService = BaseHttpHelper.create()

    val mDataLiveData = MutableLiveData<ArrayList<WxGroupBean>>()

    fun getAllGroup(){
        requestData({
            service.getWxGroup()
        },{
            mDataLiveData.postValue(it.data)
        },{

        })
    }

}