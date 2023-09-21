package com.yuuuuke.wanandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.model.KnowledgeSystemBean
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.ProjectNetService
import kotlinx.coroutines.launch

/**
 * description:广场
 *
 * @author zwp
 * @since 2021/3/29
 */
class SquareFragmentViewModel: BaseViewModel() {

    private val service:ProjectNetService = BaseHttpHelper.create()

    val dataLiveData = MutableLiveData<ArrayList<KnowledgeSystemBean>>()

    fun getTreeData(){
        viewModelScope.launch {
            requestData({
                service.getKnowledgeTree()
            },{
                dataLiveData.postValue(it.data)
            },{

            })
        }
    }

}