package com.ouweibin.interview.features.main

import android.os.Bundle
import android.view.View
import com.ouweibin.interview.R
import com.ouweibin.interview.core.platform.BaseFragment
import com.ouweibin.interview.features.main.adapter.MainFragmentAdapter
import com.ouweibin.interview.features.main.view.CityGuideFragment
import com.ouweibin.interview.features.main.view.EatFragment
import com.ouweibin.interview.features.main.view.ShopFragment
import kotlinx.android.synthetic.main.activity_fragment.*

class MainFragment: BaseFragment() {
    override fun layoutId(): Int = R.layout.activity_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = MainFragmentAdapter(arrayListOf(CityGuideFragment(), ShopFragment(), EatFragment()), activity!!.supportFragmentManager)
        // 绑定
        tabLayout.setupWithViewPager(viewPager)
        val titles = resources.getStringArray(R.array.titles)
        for (i in 0 until titles.size ) {
            tabLayout.getTabAt(i)?.text = titles[i]
        }
    }
}