package com.yuuuuke.wanandroid.fragment

import android.util.Log
import com.chad.library.adapter.base.module.LoadMoreModule
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.adapter.ProjectAdapter
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.model.ProjectTreeBean
import com.yuuuuke.wanandroid.viewmodel.ProjDetailViewModel
import kotlinx.android.synthetic.main.fragment_proj_detail.*

class ProjectDetailFragment(val data: ProjectTreeBean) : BaseFragment<ProjDetailViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_proj_detail
    }

    override fun initData() {
        val adapter = ProjectAdapter()
        adapter.loadMoreModule.setOnLoadMoreListener {
            vm.getData(data.id)
        }
        rv_list.adapter = adapter
        vm.getData(data.id)
        vm.listDataLiveData.observe(this) {
            adapter.addData(it)
            adapter.loadMoreModule.loadMoreComplete()
        }
        vm.loadEndLiveData.observe(this) {
            adapter.loadMoreModule.loadMoreEnd()
        }
    }

}