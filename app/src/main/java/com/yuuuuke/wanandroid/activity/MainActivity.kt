package com.yuuuuke.wanandroid.activity

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseActivity
import com.yuuuuke.wanandroid.databinding.ActivityMainBinding
import com.yuuuuke.wanandroid.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViewModel():MainViewModel {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun initView() {
        NavigationUI.setupWithNavController(bottom_nav_view,findNavController(R.id.nav_host_fragment))
    }
}

