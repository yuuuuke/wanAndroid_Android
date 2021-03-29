package com.yuuuuke.wanandroid.activity

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseActivity
import com.yuuuuke.wanandroid.databinding.ActivityMainBinding
import com.yuuuuke.wanandroid.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViewModel() {
        vm = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun initView() {
        bottom_nav_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_dest -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.jump_to_main)
                }
                R.id.project_dest -> {

                }
                R.id.square_dest -> {

                }
                R.id.wechat_dest -> {

                }
                R.id.mine_dest -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.jump_to_mine)
                }
            }
            true
        }
    }
}

