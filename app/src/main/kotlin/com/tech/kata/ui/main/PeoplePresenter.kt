package com.tech.kata.ui.main

import javax.inject.Inject

class PeoplePresenter @Inject constructor(
    private val peopleProvider: PeopleProvider
) : MainContract.Presenter {

    private lateinit var view: MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun getPeople() {
        peopleProvider.getPeople()
            .subscribe {
                when(it){
                    is PeopleResult.Success-> {
                        val name =
                            it.result.firstOrNull {
                                    people -> people.name.contains("R") }?.name ?: "Not Found!!!"

                        view.showName(name)
                    } else -> {
                        view.showErrorMessage("Error in connection")
                    }
                }

        }
    }
}