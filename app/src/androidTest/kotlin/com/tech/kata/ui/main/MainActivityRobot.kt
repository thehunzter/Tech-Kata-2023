package com.tech.kata.ui.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.tech.kata.R
import org.hamcrest.Matchers

class MainActivityRobot {

    fun seeSearchButton():MainActivityRobot {
        onView(withId(R.id.searchingButton)).check(matches(isDisplayed()))

        return this
    }

    fun searchClick(): MainActivityRobot {
        onView(withId(R.id.searchingButton)).perform(click())
        return this
    }

    fun seeTextResult(result: String): MainActivityRobot {
        onView(withId(R.id.mainScreenText)).check(matches(withText( result)))
        return this
    }

}