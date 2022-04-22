package com.example.countries.presentation.main

import android.os.Bundle
import com.example.countries.R
import com.example.countries.data.models.CountryModel
import com.example.countries.presentation.base.BaseActivity
import com.example.countries.presentation.common.listeners.CountryClickListener
import com.example.countries.presentation.countries_list.CountriesListFragment
import com.example.countries.presentation.country_details.CountryDetailsFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainActivity : BaseActivity<MainActivityPresenter>(), MainActivityView, CoroutineScope,
    HasAndroidInjector, CountryClickListener {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    private var job: Job = Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        presenter.attach(this)
    }

    private fun initViews() {

        launch {
            val result =  presenter.callGetCountries()
            onResult(ArrayList(result))
        }

    }

    private fun onResult(countries: ArrayList<CountryModel>) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.flContentList)
        if (currentFragment == null || currentFragment::class != CountriesListFragment::class) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.flContentList, CountriesListFragment.newInstance(countries, this))
                .commit()
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return fragmentInjector
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCountryClick(index: Int, country: CountryModel) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContentDetails, CountryDetailsFragment.newInstance(country))
            .commit()
    }

}