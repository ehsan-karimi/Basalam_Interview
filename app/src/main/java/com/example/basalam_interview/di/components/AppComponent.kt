package com.example.basalam_interview.di.components

import android.content.Context
import com.example.basalam_interview.di.DiApplication
import com.example.basalam_interview.di.modules.ActivityModule
import com.example.basalam_interview.di.modules.ProductsRepositoryModule
import com.example.basalam_interview.repositories.ProductsRepository
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, ProductsRepositoryModule::class])
interface AppComponent : AndroidInjector<DiApplication> {

    fun productsRepository(): ProductsRepository

    @Component.Builder
    interface builder {
        fun build(): AppComponent

        @BindsInstance
        fun setContext(context: Context): builder
    }
}