package com.tech.kata.ui.main

import com.tech.kata.ui.main.base.TechKataActivityScenarioRule
import com.tech.kata.ui.main.mockconfig.MockWebServerRobot
import com.tech.kata.ui.main.mockconfig.MockWebServerRule
import com.tech.kata.ui.main.mockconfig.UserAction
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test


internal class MainActivityTest {

    @get:Rule
     var mockWebServer : MockWebServerRule = MockWebServerRule()

    private val activityScenarioRule = TechKataActivityScenarioRule<MainActivity>()

    val robot = MainActivityRobot()

    private val mockWebServerRobot = MockWebServerRobot(mockWebServer)

    @Test
    fun onSearchClick_givenSuccessful_seesThePeopleNameContainsR() {
        activityScenarioRule.launchActivity(MainActivity::class.java)

        robot.seeSearchButton()

        mockWebServerRobot.useQueueDispatcher()
            .performNoSyncAction(object : UserAction {
                override fun perform() {
                    robot.searchClick()
                }
            })

        robot.seeTextResult("R2-D2")

    }
}