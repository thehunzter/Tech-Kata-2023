package com.tech.kata.msl.people

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PeopleServiceModule(private val retrofit: Retrofit) {

  @Provides
  internal fun providesPeopleService(): PeopleService {
    return retrofit.create(PeopleService::class.java)
  }
}
