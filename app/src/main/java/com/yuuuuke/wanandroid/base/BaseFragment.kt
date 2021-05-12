package com.yuuuuke.wanandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.BR
import com.yuuuuke.wanandroid.viewmodel.MineFragmentViewModel

/**
 * description:fragment基类
 *
 * @author zwp
 * @since 2021/3/10
 */
abstract class BaseFragment<V : ViewModel, K : ViewDataBinding> : Fragment() {

    private lateinit var vb: K
    lateinit var vm: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = DataBindingUtil.inflate<K>(inflater, getLayoutId(), container, false)
        vb.lifecycleOwner = this
        initViewModel()
        vb.setVariable(BR.vm, vm)
        initData(vb.root)
        return vb.root
    }

    open fun initData(rootView:View){

    }

    abstract fun getLayoutId(): Int

    abstract fun initViewModel()
}