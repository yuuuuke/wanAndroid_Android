package com.yuuuuke.wanandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.model.ProjectTreeBean
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.ProjectNetService
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * description:项目
 *
 * @author zwp
 * @since 2021/3/29
 */
class ProjectFragmentViewModel : BaseViewModel() {

    private val service: ProjectNetService = BaseHttpHelper.create()

    private val _groupDataLiveData = MutableLiveData<ArrayList<ProjectTreeBean>>()
    val groupDataLiveData: LiveData<ArrayList<ProjectTreeBean>> = _groupDataLiveData

    fun getGroupData() {
        requestData({
            service.getProjectTree()
        }, {
            _groupDataLiveData.postValue(it.data)
        }, {
            if (it.code == -1) {
                commonUiChange.showToast.value = "数据请求失败，请稍后重试"
            } else {
                commonUiChange.showToast.value = it.message
            }
        })
    }

}