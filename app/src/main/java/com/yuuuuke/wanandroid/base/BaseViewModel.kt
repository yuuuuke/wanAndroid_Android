package com.yuuuuke.wanandroid.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuuuuke.wanandroid.model.DialogBean
import com.yuuuuke.wanandroid.model.ErrorBean
import com.yuuuuke.wanandroid.utils.DataCenter
import com.yuuuuke.wanandroid.utils.KtLog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    val jumpToLogin by lazy {
        MutableSharedFlow<Boolean>()
    }

    inner class UiChange {

        val showDialog by lazy {
            MutableLiveData<DialogBean>()
        }

        val showToast by lazy {
            MutableLiveData<String>()
        }
    }

    protected fun <T : BaseBean<*>> requestData(
        doFunction: suspend CoroutineScope.() -> T,
        onSuccess: (data: T) -> Unit,
        onError: (error: ErrorBean) -> Unit
    ) {
        viewModelScope.launch {
            runCatching {
                withContext(Dispatchers.IO) {
                    doFunction()
                }
            }.onSuccess {
                if (it.errorCode == 0) {
                    onSuccess(it)
                } else {
                    onError(ErrorBean(it.errorCode, it.errorMsg, null))
                }
            }.onFailure {
                KtLog("数据请求错误" + it.message)
                onError(ErrorBean(error = it))
            }
        }
    }

    //有个登录验证
    protected fun <T : BaseBean<*>> requestDataAfterLogin(
        doFunction: () -> T,
        onSuccess: (data: T) -> Unit,
        onError: (error: ErrorBean) -> Unit
    ) {
        DataCenter.user?.let {
            viewModelScope.launch {
                runCatching {
                    withContext(Dispatchers.IO) {
                        doFunction()
                    }
                }.onSuccess {
                    if (it.errorCode == 0) {
                        onSuccess(it)
                    } else {
                        onError(ErrorBean(it.errorCode, it.errorMsg, null))
                    }
                }.onFailure {
                    onError(ErrorBean(error = it))
                }
            }
        } ?: let {
            //没有登录，跳到登录页面去
            viewModelScope.launch {
                jumpToLogin.emit(true)
            }
        }
    }
}

