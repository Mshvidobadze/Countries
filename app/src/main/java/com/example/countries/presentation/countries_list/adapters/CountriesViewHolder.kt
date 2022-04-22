package com.example.countries.presentation.countries_list.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_country.view.*

class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView? = itemView.tvCountryName
}