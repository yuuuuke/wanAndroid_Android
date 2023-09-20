package com.yuuuuke.wanandroid.fragment

import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseVBFragment
import com.yuuuuke.wanandroid.databinding.FragmentSearchBinding
import com.yuuuuke.wanandroid.viewmodel.SearchViewModel

/**
 * description:搜索
 *
 * @author zwp
 * @since 2021/3/29
 */
class SearchFragment : BaseVBFragment<SearchViewModel, FragmentSearchBinding>() {

    override fun initViewModel(): SearchViewModel {
        return ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_search
    }
}