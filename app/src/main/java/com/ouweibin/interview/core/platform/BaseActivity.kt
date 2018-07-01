package com.ouweibin.interview.core.platform

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ouweibin.interview.R
import com.ouweibin.interview.core.extension.inTransaction

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) =
            savedInstanceState ?: supportFragmentManager.inTransaction {
                add(R.id.fragmentContainer, fragment())
            }

    abstract fun fragment(): BaseFragment
}
