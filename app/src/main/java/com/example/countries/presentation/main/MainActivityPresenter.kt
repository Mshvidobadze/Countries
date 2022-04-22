package com.example.countries.presentation.main

import com.example.countries.data.models.CountryModel
import com.example.countries.data.repositories.CountryRepository
import com.example.countries.presentation.base.BasePresenter
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    private val countryRepository: CountryRepository
): BasePresenter<MainActivityView>() {

    override fun onFirstAttach() {
        super.onFirstAttach()
    }

    suspend fun callGetCountries(): List<CountryModel>{
        return countryRepository.getCountries()
    }


}