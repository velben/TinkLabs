package com.ouweibin.interview.core.navigator

import android.content.Context
import com.ouweibin.interview.features.main.MainActivity

object Navigator{
    fun showMain(context: Context) {
        context.startActivity(MainActivity.callingIntent(context))
    }
}