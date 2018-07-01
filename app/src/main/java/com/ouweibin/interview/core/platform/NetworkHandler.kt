package com.ouweibin.interview.core.platform

import android.content.Context
import com.ouweibin.interview.core.extension.networkInfo

object NetworkHandler{
    fun isConnected(context: Context) = context.networkInfo?.isConnectedOrConnecting
}