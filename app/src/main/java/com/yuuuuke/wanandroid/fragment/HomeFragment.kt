package com.yuuuuke.wanandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.utils.KtLog
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * description:所有的Fragment的容器
 *
 * @author zwp
 * @since 2021/6/5
 */
class HomeFragment : Fragment() {

    private val mainFragment by lazy { MainFragment() }
    private val projectFragment by lazy { ProjectFragment() }
    private val squareFragment by lazy { SquareFragment() }
    private val weChatPublicFragment by lazy { WeChatPublicFragment() }
    private val mineFragment by lazy { MineFragment() }

    private var currentFragment: Fragment? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initData(view)
        return view
    }

    private fun initData(view: View) {
        KtLog("首页初始化")
        showFragment(mainFragment)
        view.bottom_nav_view.setOnNavigationItemSelectedListener {
            currentFragment?.let { fragment ->
                parentFragmentManager.beginTransaction().hide(fragment).commit()
            }
            when (it.itemId) {
                R.id.mainFragment -> {
                    showFragment(mainFragment)
                }
                R.id.projectFragment -> {
                    showFragment(projectFragment)
                }
                R.id.squareFragment -> {
                    showFragment(squareFragment)
                }
                R.id.weChatFragment -> {
                    showFragment(weChatPublicFragment)
                }
                R.id.mineFragment -> {
                    showFragment(mineFragment)
                }
            }
            true
        }
    }

    private fun showFragment(fragment:Fragment) {
        currentFragment = fragment
        if (fragment.isAdded) {
            parentFragmentManager.beginTransaction().show(fragment).commit()
        } else {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment).commit()
        }
    }
}