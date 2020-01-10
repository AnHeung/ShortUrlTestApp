package com.giftm.shorturltestapplication

import android.app.Application
import com.giftm.shorturltestapplication.di.appModule
import org.koin.android.ext.android.startKoin

class ShortApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModule)
    }
}