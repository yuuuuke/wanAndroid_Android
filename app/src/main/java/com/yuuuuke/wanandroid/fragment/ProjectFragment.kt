package com.yuuuuke.wanandroid.fragment

import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.databinding.FragmentProjectBinding
import com.yuuuuke.wanandroid.viewmodel.ProjectFragmentViewModel

/**
 * description:项目
 *
 * @author zwp
 * @since 2021/3/29
 */
class ProjectFragment : BaseFragment<ProjectFragmentViewModel, FragmentProjectBinding>() {
    override fun initViewModel(): ProjectFragmentViewModel {
        return ViewModelProvider(this).get(ProjectFragmentViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_project
    }
}