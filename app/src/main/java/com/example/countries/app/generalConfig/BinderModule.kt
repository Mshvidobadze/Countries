package com.example.countries.app.generalConfig

import com.example.countries.data.repositories.CountryRepository
import com.example.countries.data.repositories.CountryRepositoryImpl
import dagger.Binds
import dagger.Module
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
abstract class BinderModule {

    @Binds
    @Singleton
    abstract fun countries(countries: CountryRepositoryImpl): CountryRepository

}