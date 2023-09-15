package com.tech.kata

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class BaseAppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun providesContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun providesResources(): Resources {
        return application.resources
    }
}
