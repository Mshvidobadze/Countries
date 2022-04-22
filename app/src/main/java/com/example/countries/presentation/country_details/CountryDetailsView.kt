package com.example.countries.presentation.country_details

import com.example.countries.data.models.CountryModel
import com.example.countries.presentation.base.BaseView

interface CountryDetailsView: BaseView {

    fun drawCountryDetails(country: CountryModel)

}