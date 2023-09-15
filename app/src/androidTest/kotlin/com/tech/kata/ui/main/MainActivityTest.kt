package com.tech.kata.ui.main

import androidx.test.filters.LargeTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tech.kata.ui.main.base.TechKataActivityScenarioRule
import com.tech.kata.ui.main.mockconfig.MockWebServerRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityTestRule = TechKataActivityScenarioRule<MainActivity>()

    @get:Rule
    val mockWebServerRule = MockWebServerRule()


    private val mainActivityRobot = MainActivityRobot()

    @Before
    fun setUp() {
    }

    @Test
    fun changeText_sameActivity() {
        launchActivity()

        mainActivityRobot
            .seesMainText("R2-D2")
    }

    private fun launchActivity() {
        activityTestRule.launchActivity(MainActivity::class.java)
    }
}