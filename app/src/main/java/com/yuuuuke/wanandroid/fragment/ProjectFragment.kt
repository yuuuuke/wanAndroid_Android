package com.yuuuuke.wanandroid.fragment

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.base.BaseVBFragment
import com.yuuuuke.wanandroid.databinding.FragmentProjectBinding
import com.yuuuuke.wanandroid.model.ProjectTreeBean
import com.yuuuuke.wanandroid.viewmodel.ProjectFragmentViewModel
import kotlinx.android.synthetic.main.fragment_project.*

/**
 * description:项目
 *
 * @author zwp
 * @since 2021/3/29
 */
class ProjectFragment : BaseVBFragment<ProjectFragmentViewModel, FragmentProjectBinding>() {
    override fun initViewModel(): ProjectFragmentViewModel {
        return ViewModelProvider(this).get(ProjectFragmentViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_project
    }

    override fun initData(rootView: View) {
        super.initData(rootView)
        vm.getGroupData()
        vm.groupDataLiveData.observe(this) {
            val adapter = DetailAdapter(this,it)
            viewpager.adapter = adapter
            val tableLayoutMediator = TabLayoutMediator(tabLayout, viewpager) { tab, position ->
                tab.text = it[position].name
            }
            tableLayoutMediator.attach()
        }
    }
}

class DetailAdapter(frg: Fragment, val data: ArrayList<ProjectTreeBean>) :
    FragmentStateAdapter(frg) {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun createFragment(position: Int): Fragment {
        return ProjectDetailFragment(data[position]);
    }

}