package com.example.jetnews

import android.app.Application
import com.example.jetnews.data.AppContainer
import com.example.jetnews.data.AppContainerImpl

class JetNewsApplication : Application() {
    companion object {
        const val JETNEWS_APP_URI = "https://developer.android.com/jetnews"
    }

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}