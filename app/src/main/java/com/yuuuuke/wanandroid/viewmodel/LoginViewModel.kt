package com.yuuuuke.wanandroid.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.model.UserBean
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.LoginService
import com.yuuuuke.wanandroid.utils.KtLog

/**
 * description:登录的ViewModel
 *
 * @author zwp
 * @since 2021/5/19
 */
class LoginViewModel: BaseViewModel() {

    val service: LoginService = BaseHttpHelper.create()
    val successLiveData = MutableLiveData<UserBean>()

    fun login(username:String,password:String){
        requestData({
            service.login(username,password)
        },{
            commonUiChange.showToast.postValue(it.errorMsg)
            // 成功
            successLiveData.postValue(it.data)
        },{
            KtLog("///"+it.toString())
            commonUiChange.showToast.postValue(it.message)
        })
    }

}