package com.tech.kata.ui.main

class MainContract {

    interface Presenter {
        fun setView(view: View)
        fun getPeople()
    }

    interface View {
        fun showName(name: String)
        fun showErrorMessage(message: String)
    }
}