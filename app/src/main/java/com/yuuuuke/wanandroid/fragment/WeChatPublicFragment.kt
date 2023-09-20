package com.yuuuuke.wanandroid.fragment

import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseVBFragment
import com.yuuuuke.wanandroid.databinding.FragmentWechatPublicBinding
import com.yuuuuke.wanandroid.viewmodel.WeChatPublicFragmentViewModel

/**
 * description:公众号
 *
 * @author zwp
 * @since 2021/3/29
 */
class WeChatPublicFragment :
    BaseVBFragment<WeChatPublicFragmentViewModel, FragmentWechatPublicBinding>() {
    override fun initViewModel(): WeChatPublicFragmentViewModel {
        return ViewModelProvider(this).get(WeChatPublicFragmentViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_wechat_public
    }
}