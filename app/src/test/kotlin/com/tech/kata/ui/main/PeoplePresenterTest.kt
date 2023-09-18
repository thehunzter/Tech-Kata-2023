package com.tech.kata.ui.main

import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PeoplePresenterTest {

    @InjectMocks
    lateinit var peoplePresenter: PeoplePresenter

    @Mock
    lateinit var provider: PeopleProvider

    @Mock
    private lateinit var view: PeopleContract.View

    @Before
    fun setUp() {
        peoplePresenter.setView(view)

        `when`(provider.getPeople()).thenReturn(
            Observable.just(PeopleResult.Successful(listOf(PeopleView("R2-D2"))))
        )
    }

    @Test
    fun getPeople_callsProviderGetPeople() {
        peoplePresenter.getPeople()

        verify(provider).getPeople()
    }

    @Test
    fun getPeople_givenPeopleReturnsPeopleWithR_callsShowNameWithName() {
        peoplePresenter.getPeople()

        verify(view).showName("R2-D2")
    }

    @Test
    fun getPeople_givenPeopleReturnsPeopleWithoutR_callsShowNameWithEmptyValue() {
        `when`(provider.getPeople()).thenReturn(
            Observable.just(PeopleResult.Successful(listOf(PeopleView("G2-D2"))))
        )

        peoplePresenter.getPeople()

        verify(view).showName("")
    }
}