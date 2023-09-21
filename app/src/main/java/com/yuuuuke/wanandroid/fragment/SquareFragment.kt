package com.yuuuuke.wanandroid.fragment

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.adapter.KnowledgeTreeAdapter
import com.yuuuuke.wanandroid.base.BaseVBFragment
import com.yuuuuke.wanandroid.databinding.FragmentSquareBinding
import com.yuuuuke.wanandroid.viewmodel.SquareFragmentViewModel
import kotlinx.android.synthetic.main.fragment_square.*

/**
 * description:广场
 *
 * @author zwp
 * @since 2021/3/29
 */
class SquareFragment : BaseVBFragment<SquareFragmentViewModel, FragmentSquareBinding>() {

    override fun initViewModel(): SquareFragmentViewModel {
        return ViewModelProvider(this).get(SquareFragmentViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_square
    }

    override fun initData(rootView: View) {
        super.initData(rootView)
        val adapter = KnowledgeTreeAdapter()
        rootView.findViewById<RecyclerView>(R.id.group_list).adapter = adapter
        vm.getTreeData()
        vm.dataLiveData.observe(this){
            adapter.addData(it)
        }
    }
}