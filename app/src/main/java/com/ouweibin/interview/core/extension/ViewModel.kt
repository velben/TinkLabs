package com.ouweibin.interview.core.extension

import android.arch.lifecycle.ViewModel

fun ViewModel.observe(body:()->Unit){
    body()
}