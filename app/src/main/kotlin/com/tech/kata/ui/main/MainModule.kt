package com.tech.kata.ui.main

import com.tech.kata.msl.people.PeopleObjectGraph
import com.tech.kata.msl.people.PeopleService
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class MainModule {

    @Binds
    abstract fun providesMainPresenter(
        mainPresenter: PeoplePresenter
    ): MainContract.Presenter
}
