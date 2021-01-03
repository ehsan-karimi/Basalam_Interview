package com.example.basalam_interview.Di.Components

import android.content.Context
import com.example.basalam_interview.Di.DiApplication
import com.example.basalam_interview.Di.Modules.ActivityModule
import com.example.basalam_interview.Di.Modules.ProductsRepositoryModule
import com.example.basalam_interview.Repositories.ProductsRepository
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