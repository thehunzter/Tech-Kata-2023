package com.tech.kata.ui.main

import com.tech.kata.msl.people.People
import com.tech.kata.msl.people.PeopleResponse
import com.tech.kata.msl.people.PeopleService
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PeopleProviderTest {

    @InjectMocks
    lateinit var peopleProvider: PeopleProvider

    @Mock
    lateinit var peopleService: PeopleService

    @Mock
    lateinit var peopleResponse: PeopleResponse

    @Test
    fun getPeople_givenResponseSuccessful_returnPeopleResult() {
        `when`(peopleResponse.results).thenReturn(listOf(People("R2-D2")))
        `when`(peopleService.getPeople()).thenReturn(Observable.just(peopleResponse))

        val actual = peopleProvider.getPeople().test()

        actual.assertValue { result ->
            result is PeopleResult.Successful
            (result as PeopleResult.Successful).results[0].name == "R2-D2"
        }
    }
}