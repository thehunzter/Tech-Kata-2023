package com.tech.kata.ui.main

class PeopleContract {

    interface Presenter {
        fun setView(view: View)
        fun getPeople()
    }

    interface View {
        fun showName(name: String)
    }
}