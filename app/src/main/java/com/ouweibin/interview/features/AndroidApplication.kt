package com.ouweibin.interview.features

import android.app.Application

class AndroidApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Instant = this
    }

    companion object {
        private lateinit var Instant:Application
        fun get(): Application = Instant
    }
}