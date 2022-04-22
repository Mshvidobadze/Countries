package com.example.countries.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LanguageModel(
    val code: String,
    val name: String?
): Parcelable
