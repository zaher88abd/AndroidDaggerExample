package dev.zaherabd.daggerexample.di

import dagger.Component
import dev.zaherabd.daggerexample.mainactivity.MainActivityViewModel
import javax.inject.Singleton


@Singleton
@Component(modules = [RetroModule::class])
interface RetoComponent {
    fun inject(mainActivityViewModel: MainActivityViewModel)
}