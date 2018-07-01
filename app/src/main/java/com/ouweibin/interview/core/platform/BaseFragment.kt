package com.ouweibin.interview.core.platform

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ouweibin.interview.R
import com.ouweibin.interview.core.extension.appContext
import com.ouweibin.interview.core.extension.inflate
import com.ouweibin.interview.core.extension.viewContainer

abstract class BaseFragment: Fragment() {
    abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            container?.inflate(layoutId())

    open fun onBackPressed(){}

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

    internal fun notify(@StringRes message: Int) =
            Snackbar.make(viewContainer, message, Snackbar.LENGTH_LONG).show()

    internal  fun notifyWithAction(@StringRes message: Int, @StringRes actionText: Int, action: () -> Any) {
        val snackbar = Snackbar.make(viewContainer, message, Snackbar.LENGTH_LONG)
        snackbar.setAction(actionText) {_ -> action.invoke()}
        snackbar.setActionTextColor(ContextCompat.getColor(appContext, R.color.colorTextPrimary))
        snackbar.show()
    }
}