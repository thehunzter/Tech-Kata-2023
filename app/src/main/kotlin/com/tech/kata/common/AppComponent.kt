package com.tech.kata.common

import com.tech.kata.BaseAppComponent
import com.tech.kata.TechKataApplication
import com.tech.kata.ui.main.MainModule
import com.tech.kata.ui.main.MainActivity
import com.tech.kata.ui.main.MainInjectorModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            AppModule::class,
            MainInjectorModule::class
        ]
)
interface AppComponent : BaseAppComponent {

    fun inject(techKataApplication: TechKataApplication)

}
