package com.tsukajizo.weathers

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * com.tsukajizo.weathers
 */
@HiltAndroidApp
class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
    }
}