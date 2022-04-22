package com.example.countries.data.repositories

import com.example.countries.data.models.CountryModel

interface CountryRepository {
    suspend fun getCountries(): List<CountryModel>
}