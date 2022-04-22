package com.example.countries.presentation.country_details

import com.example.countries.app.scopes.PerFragment
import com.example.countries.data.models.CountryModel
import com.example.countries.presentation.COUNTRY_DETAILS
import com.example.countries.presentation.base.BasePresenter
import javax.inject.Inject
import javax.inject.Named

@PerFragment
class CountryDetailsPresenter@Inject constructor(
    @Named(COUNTRY_DETAILS) private val country: CountryModel
): BasePresenter<CountryDetailsView>() {

    override fun onFirstAttach() {

        view?.drawCountryDetails(country)

    }

}