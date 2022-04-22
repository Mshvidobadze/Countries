package com.example.countries.presentation.country_details

import android.os.Bundle
import com.example.countries.presentation.COUNTRY_DETAILS
import android.view.View
import com.example.countries.R
import com.example.countries.app.scopes.PerFragment
import com.example.countries.data.models.CountryModel
import com.example.countries.presentation.base.BaseSupportFragment
import kotlinx.android.synthetic.main.activity_country_details_fragment.*

@PerFragment
class CountryDetailsFragment: BaseSupportFragment<CountryDetailsPresenter>(),
    CountryDetailsView {

    override fun layoutId() = R.layout.activity_country_details_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        initViews()

        presenter.attach(this)

    }

    private fun initViews() {

    }

    override fun drawCountryDetails(country: CountryModel) {
        tvCode.text = country.code
        tvName.text = country.name
        if(country.capital.isNullOrBlank()){
            tvCapitalTitle.visibility = View.GONE
            tvCapital.visibility = View.GONE
        }else{
            tvCapitalTitle.visibility = View.VISIBLE
            tvCapital.visibility = View.VISIBLE
            tvCapital.text = country.capital
        }
        tvEmoji.text = country.emoji
        if(country.currency.isNullOrBlank()){
            tvCurrencyTitle.visibility = View.GONE
            tvCurrency.visibility = View.GONE
        }else{
            tvCurrencyTitle.visibility = View.VISIBLE
            tvCurrency.visibility = View.VISIBLE
            tvCurrency.text = country.currency
        }
        if(country.language.isNotEmpty()){
            tvLanguageTitle.visibility = View.VISIBLE
            tvLanguage.visibility = View.VISIBLE
            tvLanguage.text = country.language[0].name
        }else{
            tvLanguageTitle.visibility = View.GONE
            tvLanguage.visibility = View.GONE
        }

    }

    override fun showMessage(message: String) {
        TODO("Not yet implemented")
    }

    companion object {
        fun newInstance(country: CountryModel): CountryDetailsFragment {
            val fragment = CountryDetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(COUNTRY_DETAILS, country)
            fragment.arguments = bundle
            return fragment
        }
    }

}