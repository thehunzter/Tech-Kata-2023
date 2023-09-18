package com.tech.kata.ui.main

import com.tech.kata.ui.main.base.TechKataActivityScenarioRule
import com.tech.kata.ui.main.mockconfig.MockWebServerRobot
import com.tech.kata.ui.main.mockconfig.MockWebServerRule
import com.tech.kata.ui.main.mockconfig.UserAction
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get: Rule
    val mockWebServerRule = MockWebServerRule()

    private val mockWebServerRobot = MockWebServerRobot(mockWebServerRule)

    val mainActivity = TechKataActivityScenarioRule<MainActivity>()

    val mainActivityRobot = MainActivityRobot()

     @Test
     fun onSearchClick_givenSuccessful_seesPeopleWithNameContainCharacterR() {
         mainActivity.launchActivity(MainActivity::class.java)

         mainActivityRobot
             .seesSearchButton()

         mockWebServerRobot.useQueueDispatcher()
             .performNoSyncAction (object : UserAction {
                 override fun perform() {
                     mainActivityRobot.searchClick()
                 }

             })
             .enqueueFromFile("people/get_people.json")

         mainActivityRobot.seesMainText("R2-D2")
     }

    @Test
    fun onSearchClick_givenFailure_seesErrorMessage() {
        mainActivity.launchActivity(MainActivity::class.java)

        mainActivityRobot
            .seesSearchButton()

        mockWebServerRobot.useQueueDispatcher()
            .performNoSyncAction (object : UserAction {
                override fun perform() {
                    mainActivityRobot.searchClick()
                }

            })
            .enqueueServerError()

        mainActivityRobot.seesMainText("No internet connection")
    }
 }