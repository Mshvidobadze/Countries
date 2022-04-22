package com.example.countries.presentation.countries_list

import com.example.countries.data.models.CountryModel
import com.example.countries.presentation.base.BaseView

interface CountriesListView: BaseView {

    fun refreshCountries(countriesList: MutableList<CountryModel>)

}