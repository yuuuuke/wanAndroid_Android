package com.yuuuuke.wanandroid.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.yuuuuke.wanandroid.BR

/**
 * description:Activity基类
 *
 * @author zwp
 * @since 2021/3/9
 */
abstract class BaseActivity<V : BaseViewModel, K : ViewDataBinding> : FragmentActivity() {

    private lateinit var vb: K
    lateinit var vm: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = DataBindingUtil.setContentView(this, getLayoutId())
        initViewModel()
        vb.lifecycleOwner = this
        vb.setVariable(BR.vm, vm)
        createCommonUiStateObserver()
        initView()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initViewModel()

    open fun initView() {

    }

    open fun initData() {

    }

    /**
     * 通用视图状态改变的观察者
     */
    private fun createCommonUiStateObserver() {
        vm.commonUiChange.showDialog.observe(this, Observer<Boolean> {
            showCommonDialog(it)
        })
        vm.commonUiChange.showToast.observe(this, Observer {
            showToast(it)
        })
    }

    open fun showCommonDialog(state: Boolean) {

    }

    open fun showToast(title: String) {

    }
}