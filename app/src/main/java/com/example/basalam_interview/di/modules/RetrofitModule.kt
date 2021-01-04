package com.example.basalam_interview.di.modules

import com.example.basalam_interview.model.remoteDataSource.Api_Interface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
    private var api_interface: Api_Interface? = null

    @Singleton
    @Provides
    fun provideApiInterface(): Api_Interface {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val oldRequest = chain.request()
                val newRequestBuilder = oldRequest.newBuilder()
                newRequestBuilder.addHeader("Acccept", "application/json")
                //                        newRequestBuilder.addHeader("Authorization","YOUR TOKEN");
                chain.proceed(newRequestBuilder.build())
            }
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(Api_Interface::class.java).also { api_interface = it }
    }

    companion object {
        private const val BASE_URL = "https://api.basalam.com/api/"
    }
}
