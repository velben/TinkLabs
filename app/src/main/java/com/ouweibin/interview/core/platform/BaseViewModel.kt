package com.ouweibin.interview.core.platform

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ouweibin.interview.core.exception.Failure

open class BaseViewModel: ViewModel() {
     val failure: MutableLiveData<Failure> by lazy { MutableLiveData<Failure>() }

    protected fun handleFailure(f: Failure) {
        failure.value = f
    }
}