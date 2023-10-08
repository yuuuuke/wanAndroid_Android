package com.yuuuuke.wanandroid.fragment

import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseVBFragment
import com.yuuuuke.wanandroid.databinding.FragmentCollectBinding
import com.yuuuuke.wanandroid.viewmodel.CollectViewModel

/**
 * description:公众号
 *
 * @author zwp
 * @since 2021/3/29
 */
class CollectFragment :
    BaseVBFragment<CollectViewModel, FragmentCollectBinding>() {
    override fun initViewModel(): CollectViewModel {
        return ViewModelProvider(this).get(CollectViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_collect
    }
}