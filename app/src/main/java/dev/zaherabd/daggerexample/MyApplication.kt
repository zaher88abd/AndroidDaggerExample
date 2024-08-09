package dev.zaherabd.daggerexample

import android.app.Application
import dev.zaherabd.daggerexample.di.DaggerRetoComponent
import dev.zaherabd.daggerexample.di.RetoComponent
import dev.zaherabd.daggerexample.di.RetroModule


class MyApplication : Application() {
    private lateinit var retroComponent: RetoComponent
    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerRetoComponent.builder().retroModule(RetroModule()).build()
    }

    fun getRetroComponent(): RetoComponent {
        return retroComponent
    }
}