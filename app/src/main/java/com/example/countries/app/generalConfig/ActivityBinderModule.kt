package com.example.countries.app.generalConfig

import com.example.countries.app.scopes.PerActivity
import com.example.countries.presentation.main.MainActivity
import com.example.countries.presentation.main.MainActivityBinderModule
import com.example.countries.presentation.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityBinderModule::class, MainActivityModule::class])
    abstract fun MainActivity(): MainActivity

}