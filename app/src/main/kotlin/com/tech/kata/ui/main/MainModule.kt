package com.tech.kata.ui.main

import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {

    @Binds
    abstract fun provideMainPresenter(
        mainPresenter: PeoplePresenter
    ): PeopleContract.Presenter

}
