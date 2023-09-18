package com.tech.kata.ui.main

sealed class PeopleResult {

    data class Successful(val results: List<PeopleView>) : PeopleResult()
}
