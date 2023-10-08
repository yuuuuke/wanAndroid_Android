package com.yuuuuke.wanandroid.fragment

import android.view.View
import androidx.lifecycle.lifecycleScope
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.viewmodel.DetailAction
import com.yuuuuke.wanandroid.viewmodel.WxArticleDetailViewModel
import kotlinx.android.synthetic.main.fragment_knowledge_detail.*
import kotlinx.android.synthetic.main.fragment_wx_article_detail.*
import kotlinx.coroutines.launch

class WxArticleDetailFragment : BaseFragment<WxArticleDetailViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_wx_article_detail
    }

    override fun initData() {
        lifecycleScope.launchWhenResumed {
            vm.stateFlow.collect {
                if(it.searchMode){
                    normal_title.visibility = View.GONE
                    search_title.visibility = View.VISIBLE
                }else{
                    normal_title.visibility = View.VISIBLE
                    search_title.visibility = View.GONE

                }
            }
        }
        val id = arguments?.getInt("ID", -1) ?: -1
        val title = arguments?.getString("NAME", "") ?: ""
        tv_name.text = title
        vm.dispatch(DetailAction.GetDetailData(id))
    }
}