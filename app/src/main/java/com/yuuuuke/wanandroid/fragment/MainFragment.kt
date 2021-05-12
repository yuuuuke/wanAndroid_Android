package com.yuuuuke.wanandroid.fragment

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.databinding.FragmentMainBinding
import com.yuuuuke.wanandroid.viewmodel.MainFragmentViewModel

/**
 * description:主界面fragment
 *
 * @author zwp
 * @since 2021/3/10
 */
class MainFragment : BaseFragment<MainFragmentViewModel, FragmentMainBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initViewModel() {
        vm = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
    }

    override fun initData(rootView: View) {
        super.initData(rootView)
    }
}