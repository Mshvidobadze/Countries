package com.example.countries.presentation.common.listeners

import com.example.countries.data.models.CountryModel

interface CountryClickListener {

    fun onCountryClick(index: Int, country: CountryModel)

}