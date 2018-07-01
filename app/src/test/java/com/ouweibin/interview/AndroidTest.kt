package com.ouweibin.interview

import android.app.Application
import android.content.Context
import com.ouweibin.interview.core.platform.BaseActivity
import org.junit.Rule
import org.mockito.Mockito.mock
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Android tests的基类
 */
@Config(constants = BuildConfig::class,
        application = AndroidTest.ApplicationStub::class,
        sdk = [21],
        manifest=Config.DEFAULT_VALUE_STRING)
abstract class AndroidTest {

    @Suppress("LeakingThis")
    @Rule @JvmField val injectMocks = InjectMocksRule.create(this@AndroidTest)

    fun context(): Context = RuntimeEnvironment.application

    fun activityContext(): Context = mock(BaseActivity::class.java)

    internal class ApplicationStub : Application()
}