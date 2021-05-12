package com.yuuuuke.wanandroid.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuuuuke.wanandroid.model.DialogBean
import com.yuuuuke.wanandroid.model.ErrorBean
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.MainNetService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * description:viewmodel基类
 *
 * @author zwp
 * @since 2021/3/9
 */
open class BaseViewModel : ViewModel() {

    val commonUiChange by lazy {
        UiChange()
    }

    inner class UiChange {

        val showDialog by lazy {
            MutableLiveData<DialogBean>()
        }

        val showToast by lazy {
            MutableLiveData<String>()
        }
    }

    protected fun <T:BaseBean<*>> requestData(
        doFunction: () -> T,
        onSuccess: (data: T) -> Unit,
        onError: (error: ErrorBean) -> Unit
    ) {
        viewModelScope.launch {
            runCatching {
                withContext(Dispatchers.IO) {
                    doFunction()
                }
            }.onSuccess {
                if(it.errorCode == 0){
                    onSuccess(it)
                }else{
                    onError(ErrorBean(it.errorCode,it.errorMsg,null))
                }
            }.onFailure {
                onError(ErrorBean(error = it))
            }
        }
    }
}

