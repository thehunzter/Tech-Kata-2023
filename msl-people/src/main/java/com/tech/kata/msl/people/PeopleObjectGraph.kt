package com.tech.kata.msl.people

import retrofit2.Retrofit

class PeopleObjectGraph(retrofit: Retrofit) {

  private val component = DaggerPeopleServiceComponent.builder()
    .peopleServiceModule(PeopleServiceModule(retrofit))
    .build()

  fun peopleService(): PeopleService {
    return component.peopleService()
  }
}
