package com.tech.kata.ui.main

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
    private lateinit var peopleResponse: PeopleResponse

    @Test
    fun getPeople_givenPeopleApiResponseSuccess_returnPeopleResult() {
        `when`(peopleService.getPeople()).thenReturn(Observable.just(peopleResponse))

        val actual = peopleProvider.getPeople().test()

        actual.assertValue { result ->

            result is PeopleResult.Success
        }
    }

    @Test
    fun getPeople_givenPeopleApiResponseFailure_returnPeopleResult() {
        `when`(peopleService.getPeople()).thenReturn(
            Observable.error(Exception("Error in connection")))

        val actual = peopleProvider.getPeople().test()

        actual.assertValue { result ->
            result is PeopleResult.GenericFailure
        }
    }

}