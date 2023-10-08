package com.yuuuuke.wanandroid.fragment

import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.adapter.WxGroupAdapter
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.viewmodel.WxArticleViewModel
import kotlinx.android.synthetic.main.fragment_wx_article.*

class WxArticleFragment: BaseFragment<WxArticleViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_wx_article
    }

    override fun initData() {
        val adapter = WxGroupAdapter()
        wx_list.adapter = adapter
        vm.getAllGroup()
        vm.mDataLiveData.observe(this){
            adapter.setData(it)
        }
    }
}