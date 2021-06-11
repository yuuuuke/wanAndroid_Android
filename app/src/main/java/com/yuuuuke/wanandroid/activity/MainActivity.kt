package com.yuuuuke.wanandroid.activity

import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseActivity
import com.yuuuuke.wanandroid.databinding.ActivityMainBinding
import com.yuuuuke.wanandroid.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViewModel(): MainViewModel {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun initData() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val nav = Navigation.findNavController(this@MainActivity, R.id.nav_host_fragment)
                if (nav.currentDestination != null && nav.currentDestination!!.id != R.id.homeFragment) {
                    //不是首页
                    nav.navigateUp()
                }else{
                    //首页，直接退出
                    finish()
                }
            }
        })
    }
}

