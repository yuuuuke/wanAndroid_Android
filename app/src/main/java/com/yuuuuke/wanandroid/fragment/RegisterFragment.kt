package com.yuuuuke.wanandroid.fragment

import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : BaseFragment<RegisterViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_register
    }

    override fun initData() {
        tv_register.setOnClickListener {
            val username = et_username.text.toString()
            val pwd = et_password.text.toString()
            val pwdRepeat = et_password_repeat.text.toString()
            vm.register(username, pwd, pwdRepeat)
        }

        iv_back.setOnClickListener {
            activity?.onBackPressed()
        }

        vm.successLiveData.observe(this){
            activity?.onBackPressed()
        }
    }

}