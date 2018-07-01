package com.ouweibin.interview.features.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.ouweibin.interview.R
import com.ouweibin.interview.core.platform.BaseActivity
import com.ouweibin.interview.core.platform.BaseFragment
import com.ouweibin.interview.features.main.adapter.MainFragmentAdapter
import com.ouweibin.interview.features.main.view.CityGuideFragment
import com.ouweibin.interview.features.main.view.EatFragment
import com.ouweibin.interview.features.main.view.ShopFragment

class MainActivity : BaseActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun fragment(): BaseFragment = MainFragment()
}
