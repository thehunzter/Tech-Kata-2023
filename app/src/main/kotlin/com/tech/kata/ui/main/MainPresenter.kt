package com.tech.kata.ui.main

import com.tech.kata.msl.people.PeopleService
import javax.inject.Inject

class MainPresenter @Inject constructor(
  private val peopleService: PeopleService
  ) : MainContract.Presenter {

  private lateinit var view: MainContract.View

  override fun setView(view: MainContract.View) {
    this.view = view
  }

  override fun onViewCreated() {
    peopleService.getPeople()
      .subscribe({
        val name =
          it.results.firstOrNull { people -> people.name.contains("R") }?.name ?: "Not Found!!!"
        view.showText(name)
      }, {})
  }
}
