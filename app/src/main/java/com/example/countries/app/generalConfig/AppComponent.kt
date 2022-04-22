package com.example.countries.app.generalConfig

import android.app.Application
import com.example.countries.data.repositories.CountryRepository
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AndroidInjectionModule::class, ActivityBinderModule::class, BinderModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

    fun countryRepository(): CountryRepository
}