package com.yuuuuke.wanandroid.fragment

import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.databinding.FragmentLoginBinding
import com.yuuuuke.wanandroid.viewmodel.LoginViewModel

/**
 * description:登录界面
 *
 * @author zwp
 * @since 2021/5/18
 */
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_login
    }

    override fun initViewModel(): LoginViewModel {
        return ViewModelProvider(this).get(LoginViewModel::class.java)
    }
}