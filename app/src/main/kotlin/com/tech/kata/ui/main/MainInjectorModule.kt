package com.tech.kata.ui.main

import com.tech.kata.msl.people.PeopleObjectGraph
import com.tech.kata.msl.people.PeopleService
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit

@Module
abstract class MainInjectorModule {

    companion object {
        @Provides
        fun providesPeopleService(peopleObjectGraph: PeopleObjectGraph): PeopleService {
            return peopleObjectGraph.peopleService()
        }

        @Provides
        fun providesPeopleObjectGraph(retrofit: Retrofit): PeopleObjectGraph {
            return PeopleObjectGraph(retrofit)
        }
    }
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivityInjector(): MainActivity


}