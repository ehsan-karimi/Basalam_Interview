package com.example.basalam_interview.Di

import com.example.basalam_interview.Di.Components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class DiApplication : DaggerApplication() {

     override fun onCreate() {
        super.onCreate()
    }

     override fun applicationInjector(): AndroidInjector<out DaggerApplication?> {
         return DaggerAppComponent.builder().setContext(baseContext).build()
    }
}