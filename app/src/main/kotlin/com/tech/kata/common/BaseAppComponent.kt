package com.tech.kata.common

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    BaseAppModule::class,
])
interface BaseAppComponent : AndroidInjector<BaseTechKataApplication> {

    override fun inject(baseSqApplication: BaseTechKataApplication)
}
