package com.tech.kata

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

open class BaseTechKataApplication : DaggerApplication() {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private val appComponent: BaseAppComponent = DaggerBaseAppComponent.builder()
        .build()

    override fun androidInjector(): AndroidInjector<Any?>? {
        return dispatchingAndroidInjector
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication?>? {
        return appComponent
    }

    open fun getAppComponent(): BaseAppComponent {
        return appComponent
    }
}
