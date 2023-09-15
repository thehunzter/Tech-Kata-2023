package com.tech.kata.msl.people

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(PeopleServiceModule::class)])
interface PeopleServiceComponent {

  fun peopleService(): PeopleService

}
