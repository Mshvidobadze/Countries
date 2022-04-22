package com.example.countries.presentation.country_details

import com.example.countries.app.scopes.PerFragment
import com.example.countries.data.models.CountryModel
import com.example.countries.presentation.COUNTRY_DETAILS
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class CountryDetailsModule {

    @PerFragment
    @Provides
    @Named(COUNTRY_DETAILS)
    fun provideDetails(fragment: CountryDetailsFragment): CountryModel {
        return fragment.requireArguments().getParcelable(COUNTRY_DETAILS)!!
    }

}