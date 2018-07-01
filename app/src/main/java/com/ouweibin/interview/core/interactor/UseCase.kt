package com.ouweibin.interview.core.interactor

import com.ouweibin.interview.core.exception.Failure
import com.ouweibin.interview.core.functional.Either
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

abstract class UseCase<out T, in Params> where T: Any{

    abstract suspend fun run(params: Params): Either<Failure, T>

    fun execute(onResult: (Either<Failure, T>) -> Unit, params: Params) {
        val job = async { run(params) }
        launch (UI){onResult.invoke(job.await())}
    }

    class None
}