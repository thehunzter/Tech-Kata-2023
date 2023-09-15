package com.tech.kata.ui.main

sealed class PeopleResult {

    data class Success(var result: List<PeopleView>): PeopleResult()

    object GenericFailure: PeopleResult()

}
