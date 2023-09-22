package com.yuuuuke.wanandroid.fragment

import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.adapter.KnowledgeDetailAdapter
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.viewmodel.KnowledgeDetailViewModel
import kotlinx.android.synthetic.main.fragment_knowledge_detail.*
import kotlinx.android.synthetic.main.fragment_proj_detail.rv_list

class KnowledgeDetailFragment: BaseFragment<KnowledgeDetailViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_knowledge_detail
    }

    override fun initData() {

        val id = arguments?.getInt("C_ID",-1)?:-1
        val title = arguments?.getString("TITLE","")?:""

        tv_title.text = title

        val adapter = KnowledgeDetailAdapter()
        adapter.loadMoreModule.setOnLoadMoreListener {
            vm.getKnowledgeDetailData(id)
        }
        rv_list.adapter = adapter
        vm.getKnowledgeDetailData(id)
        vm.listLiveData.observe(this) {
            adapter.addData(it)
            adapter.loadMoreModule.loadMoreComplete()
        }
        vm.loadFinished.observe(this) {
            adapter.loadMoreModule.loadMoreEnd()
        }
    }
}