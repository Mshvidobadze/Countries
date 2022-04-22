package com.example.countries.presentation.countries_list

import android.os.Bundle
import com.example.countries.app.scopes.PerFragment
import com.example.countries.data.models.CountryModel
import com.example.countries.presentation.COUNTRIES_LIST
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class CountriesListModule {

    @PerFragment
    @Provides
    @Named(COUNTRIES_LIST)
    fun provideList(fragment: CountriesListFragment): ArrayList<CountryModel> {
        return fragment.requireArguments().getParcelableArrayList(COUNTRIES_LIST)!!
    }
}