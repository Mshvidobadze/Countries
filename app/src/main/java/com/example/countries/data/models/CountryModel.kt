package com.example.countries.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryModel(
    val code: String,
    val name: String,
    val capital: String?,
    val emoji: String,
    val currency: String?,
    val language: List<LanguageModel>
): Parcelable
