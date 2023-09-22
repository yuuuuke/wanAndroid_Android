package com.yuuuuke.wanandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.model.ProjectDetail
import com.yuuuuke.wanandroid.model.ProjectDetailListBean
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.ProjectNetService

class KnowledgeDetailViewModel: BaseViewModel() {

    private val service:ProjectNetService = BaseHttpHelper.create()

    var mPage = 0

    val listLiveData = MutableLiveData<List<ProjectDetail>>()
    val loadFinished = MutableLiveData<Boolean>()

    fun getKnowledgeDetailData(cid:Int){
        requestData({
            service.getKnowledgeDetail(mPage,cid)
        },{
            listLiveData.postValue(it.data.datas)
            if(it.data.over){
                loadFinished.postValue(true)
            }else{
                mPage++
            }
        },{

        })
    }
}