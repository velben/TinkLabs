package com.ouweibin.interview.features.main.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MainFragmentAdapter(val list: List<Fragment>, fm: FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment = list[position]

    override fun getCount(): Int = list.size


}
