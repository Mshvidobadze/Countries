package com.example.countries.data.repositories

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.example.countries.CountriesQuery
import com.example.countries.app.generalConfig.PROVIDE_APOLLO_CLIENT
import com.example.countries.data.models.CountryModel
import com.example.countries.data.models.LanguageModel
import javax.inject.Inject
import javax.inject.Named


class CountryRepositoryImpl @Inject constructor(
    @Named(PROVIDE_APOLLO_CLIENT) private val apolloClient: ApolloClient
) : CountryRepository {
    @Suppress("UNCHECKED_CAST")
    override suspend fun getCountries(): List<CountryModel> {
        return apolloClient.query(CountriesQuery()).execute().data!!.countries
            .map { CountryModel(name = it.name,
                                code = it.code,
                                capital = it.capital,
                                emoji = it.emoji,
                                currency = it.currency,
                                language = it.languages.map { LanguageModel(code = it.code, name = it.name) }
            ) }
    }
}