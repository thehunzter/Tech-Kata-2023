package com.tech.kata.ui.main

import com.tech.kata.msl.people.PeopleResponse
import com.tech.kata.msl.people.PeopleService
import io.reactivex.Observable
import javax.inject.Inject

class PeopleProvider @Inject constructor(private val peopleService: PeopleService) {

    fun getPeople(): Observable<PeopleResult> {
        return peopleService.getPeople().flatMap {
            Observable.just(PeopleResult.Successful(map(it)))
        }
    }

    private fun map(peopleResponse: PeopleResponse): List<PeopleView> {
        return peopleResponse.results.map {
            PeopleView(it.name)
        }
    }
}