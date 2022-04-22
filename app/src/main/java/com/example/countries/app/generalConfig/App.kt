package com.example.countries.app.generalConfig

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : MultiDexApplication(), HasAndroidInjector, Application.ActivityLifecycleCallbacks {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    private var isForeground = false

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        component = DaggerAppComponent.builder()
            .application(this)
            .build() as DaggerAppComponent
        component.inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return activityInjector
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onActivityStarted(p0: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityResumed(activity: Activity) {
        isForeground = true
    }

    override fun onActivityPaused(activity: Activity) {
        isForeground = false
    }

    override fun onActivityStopped(p0: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        TODO("Not yet implemented")
    }

    override fun onActivityDestroyed(p0: Activity) {
        TODO("Not yet implemented")
    }

    fun applicationInForeground(): Boolean {
        return isForeground
    }

    companion object {
        lateinit var component: DaggerAppComponent
    }

}