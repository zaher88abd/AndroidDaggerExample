package dev.zaherabd.daggerexample.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetroModule {
    val baseURL = "https://api.github.com/search/"


    @Singleton
    @Provides
    fun getRetroFitServiceInterface(retrofit: Retrofit): RetroServiceInterface {
        return retrofit.create(RetroServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetroFitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}