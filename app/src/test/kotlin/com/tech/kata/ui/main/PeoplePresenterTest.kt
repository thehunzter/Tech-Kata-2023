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
    lateinit var peopleProvider: PeopleProvider

    @Mock
    lateinit var view: MainContract.View

    @Before
    fun setUp() {
        peoplePresenter.setView(view)
    }

    @Test
    fun getPeople_givenPeopleProviderReturnSuccess_callsShowName() {
        `when`(peopleProvider.getPeople()).thenReturn(
            Observable.just(PeopleResult.Success(listOf(PeopleView("R2-D2")))))

        peoplePresenter.getPeople()

        verify(view).showName("R2-D2")
    }

    @Test
    fun getPeople_givenPeopleProviderReturnError_neverCallsShowName() {
        `when`(peopleProvider.getPeople()).thenReturn(
            Observable.just(PeopleResult.GenericFailure))

        peoplePresenter.getPeople()

        verify(view, never()).showName("Hello World")
        verify(view).showErrorMessage("Error in connection")
    }

}