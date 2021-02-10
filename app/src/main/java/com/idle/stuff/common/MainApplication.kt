package com.idle.stuff.common

import android.app.Application
import com.idle.stuff.utils.ResExtractor
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ResExtractor.init(this)
    }
}