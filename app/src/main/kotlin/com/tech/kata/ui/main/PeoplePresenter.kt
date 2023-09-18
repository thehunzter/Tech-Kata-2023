package com.tech.kata.ui.main

import javax.inject.Inject

class PeoplePresenter @Inject constructor(
    private val provider: PeopleProvider
) : PeopleContract.Presenter {

    private lateinit var view: PeopleContract.View

    override fun setView(view: PeopleContract.View) {
        this.view = view
    }

    override fun getPeople() {
        provider.getPeople().subscribe {
            if (it is PeopleResult.Successful) {
                val name = it.results.firstOrNull { people ->
                    people.name.contains("R")
                }?.name ?: ""

                view.showName(name)
            }
        }
    }
}