package com.ouweibin.interview.core.functional

import com.ouweibin.interview.UnitTest
import com.ouweibin.interview.core.functional.Either.Left
import com.ouweibin.interview.core.functional.Either.Right
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldEqualTo
import org.junit.Test

/**
 * 测试Either类
 */
class EitherTest : UnitTest(){

    @Test
    fun isRight() {
        val result = Right("right")

        result shouldBeInstanceOf Either::class.java
        result.isRight shouldBe true
        result.isLeft shouldBe false
        result.either({}, {right ->
            right shouldBeInstanceOf String::class.java
            right shouldEqualTo "right"
        })

    }

    @Test
    fun isLeft() {
        val result = Left("left")

        result shouldBeInstanceOf Either::class.java
        result.isRight shouldBe false
        result.isLeft shouldBe true

        result.either({left ->
            left shouldBeInstanceOf String::class.java
            left shouldEqualTo "left"
        }, {})
    }

}