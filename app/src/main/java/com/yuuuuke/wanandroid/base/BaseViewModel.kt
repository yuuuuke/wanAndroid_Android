package com.yuuuuke.wanandroid.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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

    inner class UiChange{

        val showDialog by lazy{
            MutableLiveData<Boolean>()
        }

        val showToast by lazy{
            MutableLiveData<String>()
        }
    }
}

