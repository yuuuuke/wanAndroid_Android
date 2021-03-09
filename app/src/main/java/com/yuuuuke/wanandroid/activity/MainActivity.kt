package com.yuuuuke.wanandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseActivity
import com.yuuuuke.wanandroid.base.BaseViewModel
import com.yuuuuke.wanandroid.databinding.ActivityMainBinding
import com.yuuuuke.wanandroid.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViewModel() {
        vm = ViewModelProvider(this).get(MainViewModel::class.java)
    }

}
