package com.yuuuuke.wanandroid.fragment

import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.adapter.WxArticleDetailAdapter
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.viewmodel.DetailAction
import com.yuuuuke.wanandroid.viewmodel.WxArticleDetailViewModel
import kotlinx.android.synthetic.main.fragment_knowledge_detail.*
import kotlinx.android.synthetic.main.fragment_wx_article_detail.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WxArticleDetailFragment : BaseFragment<WxArticleDetailViewModel>() {

    private var searchMode = false

    override fun getLayoutId(): Int {
        return R.layout.fragment_wx_article_detail
    }

    override fun initData() {
        val id = arguments?.getInt("ID", -1) ?: -1
        val title = arguments?.getString("NAME", "") ?: ""

        val adapter = WxArticleDetailAdapter()
        adapter.loadMoreModule.setOnLoadMoreListener {
            if (searchMode) {
                if (et_keyword.text.toString().isNotEmpty()) {
                    vm.dispatch(DetailAction.SearchByKey(id, et_keyword.text.toString()))
                }else{
                    adapter.loadMoreModule.loadMoreEnd()
                }
            } else {
                vm.dispatch(DetailAction.GetDetailData(id))
            }
        }

        tv_name.text = title
        iv_to_search.setOnClickListener {
            et_keyword.setText("")
            vm.dispatch(DetailAction.ClearResultData)
            vm.dispatch(DetailAction.GoSearchMode(true))
        }
        iv_close.setOnClickListener {
            vm.dispatch(DetailAction.GoSearchMode(false))
        }
        iv_search.setOnClickListener {
            vm.dispatch(DetailAction.SearchByKey(id, et_keyword.text.toString()))
        }
        vm.dispatch(DetailAction.GetDetailData(id))
        data_list.layoutManager = LinearLayoutManager(context)
        data_list.adapter = adapter

        lifecycleScope.launchWhenResumed {
            vm.stateFlow.collect {
                withContext(Dispatchers.Main) {
                    searchMode = it.searchMode
                    if (it.searchMode) {
                        normal_title.visibility = View.GONE
                        search_title.visibility = View.VISIBLE
                        adapter.setNewInstance(it.searchResultData)
                        if (it.searchDataLoadFinish) {
                            adapter.loadMoreModule.loadMoreEnd()
                        } else {
                            adapter.loadMoreModule.loadMoreComplete()
                        }
                    } else {
                        normal_title.visibility = View.VISIBLE
                        search_title.visibility = View.GONE
                        adapter.setNewInstance(it.detailData)
                        if (it.allDataLoadFinished) {
                            adapter.loadMoreModule.loadMoreEnd()
                        } else {
                            adapter.loadMoreModule.loadMoreComplete()
                        }
                    }
                }
            }
        }
    }
}