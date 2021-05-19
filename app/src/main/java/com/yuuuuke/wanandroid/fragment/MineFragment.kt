package com.yuuuuke.wanandroid.fragment

import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.databinding.FragmentMineBinding
import com.yuuuuke.wanandroid.viewmodel.MineFragmentViewModel

/**
 * description:我的
 *
 * @author zwp
 * @since 2021/3/29
 */
class MineFragment() : BaseFragment<MineFragmentViewModel, FragmentMineBinding>() {

    override fun initViewModel(): MineFragmentViewModel {
        return ViewModelProvider(this).get(MineFragmentViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }
}