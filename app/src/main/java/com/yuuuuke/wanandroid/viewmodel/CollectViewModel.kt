package com.yuuuuke.wanandroid.viewmodel

import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.net.BaseHttpHelper
import com.yuuuuke.wanandroid.net.CollectNetService

/**
 * description:
 *
 * @author zwp
 * @since 2021/3/29
 */
class CollectViewModel: BaseViewModel() {

    val service:CollectNetService = BaseHttpHelper.create()
    var mPage = 0

    fun getData(){
        requestData({
            service.getAllCollectData(mPage)
        },{

        },{

        })
    }

}