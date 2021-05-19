package com.yuuuuke.wanandroid.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseActivity
import com.yuuuuke.wanandroid.databinding.ActivityLoginBinding
import com.yuuuuke.wanandroid.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

/**
 * description:登录界面
 *
 * @author zwp
 * @since 2021/5/18
 */
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initViewModel(): LoginViewModel {
        return ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()
    }
}