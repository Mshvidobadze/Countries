package com.example.countries.presentation.countries_list.adapters


import android.annotation.SuppressLint
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.countries.R
import com.example.countries.data.models.CountryModel
import com.example.countries.presentation.common.listeners.CountryClickListener
import kotlinx.android.synthetic.main.item_country.view.*

class CountriesAdapter(private val countryClickListener: CountryClickListener)
    : RecyclerView.Adapter<CountriesViewHolder>() {
    private var countriesList: MutableList<CountryModel> = mutableListOf()

    fun refreshCountries(countries: MutableList<CountryModel>) {
        countriesList.clear()
        countriesList.addAll(countries)

        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            itemCount == 1 -> 0
            position < itemCount - 1 -> 0
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rootView: View = when (itemCount) {
            0 -> inflater.inflate(R.layout.records_not_found, parent, false)
            else -> inflater.inflate(R.layout.item_country, parent, false)
        }
        return CountriesViewHolder(rootView)
    }


    override fun getItemCount(): Int {
        return when {
            countriesList.size == 1 -> countriesList.size
            countriesList.size > 1 -> countriesList.size + 1
            else -> 0
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {

        if(itemCount > 0){
            val country = countriesList[position]

            holder.itemView.tvCountryName.text = country.name
            holder.itemView.setOnClickListener { countryClickListener.onCountryClick(holder.adapterPosition, country) }
        }

    }
}