package com.yuuuuke.wanandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.yuuuuke.wanandroid.BR
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.utils.nav
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

/**
 * description:fragment基类
 *
 * @author zwp
 * @since 2021/3/10
 */
abstract class BaseVBFragment<V : BaseViewModel, K : ViewDataBinding> : Fragment() {

    private lateinit var vb: K
    val vm: V by lazy {
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = DataBindingUtil.inflate<K>(inflater, getLayoutId(), container, false)
        vb.lifecycleOwner = this
        vb.setVariable(BR.vm, vm)
        initData(vb.root)
        return vb.root
    }

    open fun initData(rootView: View) {
        vm.commonUiChange.showToast.observe(this.viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })

        vm.commonUiChange.showDialog.observe(this.viewLifecycleOwner, Observer {

        })

        lifecycleScope.launch {
            vm.jumpToLogin.collect(FlowCollector<Boolean> {
                nav(R.id.loginFragment)
            })
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun initViewModel(): V
}