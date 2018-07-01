package com.ouweibin.interview.core.platform

import android.arch.lifecycle.MutableLiveData
import com.ouweibin.interview.AndroidTest
import com.ouweibin.interview.core.exception.Failure
import kotlinx.coroutines.experimental.launch
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test

class BaseViewModelTest: AndroidTest() {

    @Test
    fun handleFailure() {

        val viewModel = MyViewModel()
        launch { viewModel.handlerError(Failure.NetworkConnection())
            val failure = viewModel.failure
            val error = viewModel.failure.value

            failure shouldBeInstanceOf MutableLiveData::class.java
            error shouldBeInstanceOf Failure::class.java
        }
    }

    private class MyViewModel : BaseViewModel() {
        fun handlerError(failure: Failure) = handleFailure(failure)
    }
}