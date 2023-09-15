package com.tech.kata.ui.main

import com.tech.kata.msl.people.PeopleResponse
import com.tech.kata.msl.people.PeopleService
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @InjectMocks
    private lateinit var subject: MainPresenter

    @Mock
    private lateinit var view: MainContract.View

    @Mock
    private lateinit var service: PeopleService

    @Mock
    private lateinit var response: PeopleResponse

    @Before
    fun setUp() {
        subject.setView(view)
    }

    @Test
    fun onViewCreated_showText() {
        `when`(response.results).thenReturn(listOf(PeopleResponse.People("R2-D2")))
        `when`(service.getPeople()).thenReturn(Observable.just(response))

        subject.onViewCreated()

        verify(view).showText("R2-D2")
    }
}