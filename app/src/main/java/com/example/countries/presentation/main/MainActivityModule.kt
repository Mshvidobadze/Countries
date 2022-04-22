package com.example.countries.presentation.main

import android.os.Bundle
import com.example.countries.app.scopes.PerActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @PerActivity
    @Provides
    fun provideBundle(activity: MainActivity): Bundle {
        return activity.intent.extras!!
    }

}