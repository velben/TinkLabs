package com.ouweibin.interview.core.navigator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class RouteActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Navigator.showMain(this)
    }
}