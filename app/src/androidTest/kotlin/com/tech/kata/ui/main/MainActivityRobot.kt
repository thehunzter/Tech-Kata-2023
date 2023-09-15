package com.tech.kata.ui.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.tech.kata.R

class MainActivityRobot {

    fun seesSearchButton(): MainActivityRobot {
        onView(withId(R.id.searchButton))
            .check(matches(isDisplayed()))

        return this
    }

    fun seesMainText(titleString: String): MainActivityRobot {
        onView(withId(R.id.mainScreenText))
            .check(matches(withText(titleString)))

        return this
    }
}