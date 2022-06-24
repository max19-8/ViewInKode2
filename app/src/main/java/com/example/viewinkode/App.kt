package com.example.viewinkode

import android.app.Application
import android.content.Context

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        _appContext = this
    }

    companion object{
        private lateinit var _appContext:Context
        val appContext get() = _appContext
    }
}