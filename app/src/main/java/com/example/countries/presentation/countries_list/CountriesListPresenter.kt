package com.example.countries.presentation.countries_list

import com.example.countries.app.scopes.PerFragment
import com.example.countries.data.models.CountryModel
import com.example.countries.presentation.COUNTRIES_LIST
import com.example.countries.presentation.base.BasePresenter
import javax.inject.Inject
import javax.inject.Named

@PerFragment
class CountriesListPresenter@Inject constructor(
    @Named(COUNTRIES_LIST) private val countries: ArrayList<CountryModel>
): BasePresenter<CountriesListView>() {

    override fun onFirstAttach() {

        view?.refreshCountries(countries)

    }

}