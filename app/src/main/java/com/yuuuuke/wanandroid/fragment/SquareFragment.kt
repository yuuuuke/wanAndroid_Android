package com.yuuuuke.wanandroid.fragment

import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseVBFragment
import com.yuuuuke.wanandroid.databinding.FragmentSquareBinding
import com.yuuuuke.wanandroid.viewmodel.SquareFragmentViewModel

/**
 * description:广场
 *
 * @author zwp
 * @since 2021/3/29
 */
class SquareFragment : BaseVBFragment<SquareFragmentViewModel, FragmentSquareBinding>() {

    override fun initViewModel(): SquareFragmentViewModel {
        return ViewModelProvider(this).get(SquareFragmentViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_square
    }
}