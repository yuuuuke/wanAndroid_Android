package com.yuuuuke.wanandroid.fragment

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.adapter.ArticleAdapter
import com.yuuuuke.wanandroid.base.BaseFragment
import com.yuuuuke.wanandroid.databinding.FragmentMainBinding
import com.yuuuuke.wanandroid.utils.DataCenter
import com.yuuuuke.wanandroid.utils.KtLog
import com.yuuuuke.wanandroid.utils.nav
import com.yuuuuke.wanandroid.utils.navAfterLogin
import com.yuuuuke.wanandroid.viewmodel.MainFragmentViewModel
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * description:主界面fragment
 *
 * @author zwp
 * @since 2021/3/10
 */
class MainFragment : BaseFragment<MainFragmentViewModel, FragmentMainBinding>() {

    private lateinit var adapter: ArticleAdapter
    private var page = 0

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initViewModel(): MainFragmentViewModel {
        return ViewModelProvider(this).get(MainFragmentViewModel::class.java)
    }

    override fun initData(rootView: View) {
        adapter = ArticleAdapter(null)
        adapter.loadMoreModule.setOnLoadMoreListener {
            vm.getAllArticle(++page)
        }

        rootView.rv_list.adapter = adapter
        rootView.refresh_layout.setOnRefreshListener {
            page = 0
            vm.getAllArticle(page)
        }

        vm.articleData.observe(this, Observer {
            for (bean in it) {
                bean.setType()
            }
            if (page == 0) {
                adapter.data.clear()
                adapter.data.addAll(it)
            } else {
                adapter.data.addAll(it)
            }
            adapter.notifyDataSetChanged()
            adapter.loadMoreModule.loadMoreComplete()
            rootView.refresh_layout.isRefreshing = false
        })
        vm.bannerData.observe(this, Observer {

        })

        vm.getAllArticle(page)

        rootView.iv_search.setOnClickListener {
            navAfterLogin(R.id.searchFragment)
        }
    }
}