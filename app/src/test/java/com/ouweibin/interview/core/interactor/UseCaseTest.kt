package com.ouweibin.interview.core.interactor

import com.ouweibin.interview.AndroidTest
import com.ouweibin.interview.core.exception.Failure
import com.ouweibin.interview.core.functional.Either
import kotlinx.coroutines.experimental.runBlocking
import org.amshove.kluent.shouldEqual
import org.junit.Test

class UseCaseTest : AndroidTest(){

    private val TYPE_TEST = "test"
    private val TYPE_PARAM = "ParamTest"

    private val useCase = MyUseCase()

    @Test
    fun run() {
        val params = MyParams(TYPE_TEST)
        val result = runBlocking { useCase.run(params) }

        result shouldEqual Either.Right(MyType(TYPE_TEST))
    }

    @Test
    fun execute() {

        val params = MyParams("TestParam")
        val onResult = { result: Either<Failure, MyType> ->
            result shouldEqual Either.Right(MyType(TYPE_TEST))
        }

        runBlocking { useCase.execute(onResult, params) }
    }

    data class MyType(val name: String)
    data class MyParams(val name: String)

    private inner class MyUseCase : UseCase<MyType, MyParams>() {
        override suspend fun run(params: MyParams): Either<Failure, MyType> {
            return Either.Right(MyType(TYPE_TEST))
        }
    }
}