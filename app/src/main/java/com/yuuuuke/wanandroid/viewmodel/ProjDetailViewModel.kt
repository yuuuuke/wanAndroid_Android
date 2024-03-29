package com.yuuuuke.wanandroid.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.model.ProjectDetail
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.ProjectNetService
import kotlinx.coroutines.launch

class ProjDetailViewModel : BaseViewModel() {


    val listDataLiveData = MutableLiveData<List<ProjectDetail>>()
    val loadEndLiveData = MutableLiveData<Boolean>()
    private var mPageIndex = 0;
    val service: ProjectNetService by lazy {
        BaseHttpHelper.create()
    }


    fun getData(id: Int) {
        requestData({
            service.getProjectDetail(mPageIndex, id)
        }, {
            listDataLiveData.postValue(it.data.datas)
            if(it.data.over){
                loadEndLiveData.postValue(true)
            }else{
                mPageIndex++
            }
        }, {

        })
    }

}