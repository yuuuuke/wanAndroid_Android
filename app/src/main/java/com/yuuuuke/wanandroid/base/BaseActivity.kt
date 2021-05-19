package com.yuuuuke.wanandroid.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.yuuuuke.wanandroid.BR
import com.yuuuuke.wanandroid.model.DialogBean

/**
 * description:Activity基类
 *
 * @author zwp
 * @since 2021/3/9
 */
abstract class BaseActivity<V : BaseViewModel, K : ViewDataBinding> : FragmentActivity() {

    private lateinit var vb: K
    val vm: V by lazy{
        initViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = DataBindingUtil.setContentView(this, getLayoutId())
        vb.lifecycleOwner = this
        vb.setVariable(BR.vm, vm)
        createCommonUiStateObserver()
        initView()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initViewModel():V

    open fun initView() {

    }

    open fun initData() {

    }

    /**
     * 通用视图状态改变的观察者
     */
    private fun createCommonUiStateObserver() {
        vm.commonUiChange.showDialog.observe(this, Observer<DialogBean> {
            showCommonDialog(it)
        })
        vm.commonUiChange.showToast.observe(this, Observer {
            showToast(it)
        })
    }

    open fun showCommonDialog(state: DialogBean) {

    }

    open fun showToast(title: String) {

    }
}