package com.yuuuuke.wanandroid.fragment

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseVBFragment
import com.yuuuuke.wanandroid.databinding.FragmentMineBinding
import com.yuuuuke.wanandroid.viewmodel.MineFragmentViewModel

/**
 * description:我的
 *
 * @author zwp
 * @since 2021/3/29
 */
class MineFragment : BaseVBFragment<MineFragmentViewModel, FragmentMineBinding>() {

    override fun initViewModel(): MineFragmentViewModel {
        return ViewModelProvider(this).get(MineFragmentViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initData(rootView: View) {
        super.initData(rootView)
        vb.click = ProxyClick()
    }


    inner class ProxyClick {

        fun integral() {

        }

        fun aboutMe(){
            Toast.makeText(context," it's me !",Toast.LENGTH_LONG).show()
        }
    }
}