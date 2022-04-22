package com.example.countries.presentation.main

import com.example.countries.app.scopes.PerFragment
import com.example.countries.presentation.countries_list.CountriesListFragment
import com.example.countries.presentation.countries_list.CountriesListModule
import com.example.countries.presentation.country_details.CountryDetailsFragment
import com.example.countries.presentation.country_details.CountryDetailsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBinderModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [CountriesListModule::class])
    abstract fun countriesListFragment(): CountriesListFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [CountryDetailsModule::class])
    abstract fun countryDetailsFragment(): CountryDetailsFragment

}