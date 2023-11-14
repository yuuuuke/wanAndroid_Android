package com.yuuuuke.wanandroid.fragment

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseVBFragment
import com.yuuuuke.wanandroid.databinding.FragmentLoginBinding
import com.yuuuuke.wanandroid.utils.DataCenter
import com.yuuuuke.wanandroid.utils.nav
import com.yuuuuke.wanandroid.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

/**
 * description:登录界面
 *
 * @author zwp
 * @since 2021/5/18
 */
class LoginFragment : BaseVBFragment<LoginViewModel, FragmentLoginBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_login
    }

    override fun initViewModel(): LoginViewModel {
        return ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun initData(rootView: View) {
        rootView.tv_login.setOnClickListener {
            val username = et_username.text.toString()
            val pwd = et_password.text.toString()
            vm.login(username,pwd)
        }
        rootView.iv_back.setOnClickListener {
            this.activity?.onBackPressed()
        }
        rootView.tv_to_register.setOnClickListener {
            nav(R.id.action_loginFragment_to_registerFragment)
        }
        vm.successLiveData.observe(this){
            DataCenter.user = it
            activity?.onBackPressed()
        }
    }
}