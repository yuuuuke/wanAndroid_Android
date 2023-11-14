package com.yuuuuke.wanandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.LoginService

class RegisterViewModel : BaseViewModel() {

    private val service: LoginService = BaseHttpHelper.create()
    val successLiveData = MutableLiveData<Any>()

    fun register(username: String, pwd: String, pwdRepeat: String) {
        requestData({
            service.register(username,pwd,pwdRepeat)
        },{
            successLiveData.postValue("")
            UiChange().showToast.postValue(it.errorMsg)
        },{
            UiChange().showToast.postValue(it.message)
        })
    }

}