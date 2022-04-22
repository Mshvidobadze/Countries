package com.example.countries.presentation.countries_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.countries.R
import com.example.countries.app.scopes.PerFragment
import com.example.countries.data.models.CountryModel
import com.example.countries.presentation.COUNTRIES_LIST
import com.example.countries.presentation.base.BaseSupportFragment
import com.example.countries.presentation.common.listeners.CountryClickListener
import com.example.countries.presentation.countries_list.adapters.CountriesAdapter
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_countries_list_fragment.*
import kotlinx.coroutines.launch

@PerFragment
class CountriesListFragment(private val countryClickListener: CountryClickListener) : BaseSupportFragment<CountriesListPresenter>(), CountriesListView, CountryClickListener {

    private lateinit var adapter: CountriesAdapter

    override fun layoutId() = R.layout.activity_countries_list_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        initViews()

        presenter.attach(this)

    }

    private fun initViews() {
        adapter = CountriesAdapter(this)
        rvCountries.layoutManager = LinearLayoutManager(requireContext())
        rvCountries.adapter = adapter

    }

    override fun refreshCountries(countriesList: MutableList<CountryModel>) {
        adapter.refreshCountries(countriesList)
    }

    override fun showMessage(message: String) {
        TODO("Not yet implemented")
    }

    companion object {
        fun newInstance(countries: ArrayList<CountryModel>, countryClickListener: CountryClickListener): CountriesListFragment {
            val fragment = CountriesListFragment(countryClickListener)
            val bundle = Bundle()
            bundle.putParcelableArrayList(COUNTRIES_LIST, countries)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCountryClick(index: Int, country: CountryModel) {
        countryClickListener.onCountryClick(index, country)
    }
}