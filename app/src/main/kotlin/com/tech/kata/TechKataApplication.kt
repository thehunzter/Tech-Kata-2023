package com.tech.kata

import android.app.Activity
import android.app.Service
import com.tech.kata.common.AppComponent
import com.tech.kata.common.AppModule
import com.tech.kata.common.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject


class TechKataApplication : BaseTechKataApplication() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        buildAppComponent()
        super.onCreate()

    }

     private fun buildAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

         appComponent.inject(this)
    }

    override fun getAppComponent(): AppComponent {
        return appComponent
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingServiceInjector: DispatchingAndroidInjector<Service>

}
