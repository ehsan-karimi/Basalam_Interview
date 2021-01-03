package com.example.basalam_interview.Di.Modules

import com.example.basalam_interview.Main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}