package com.tech.kata.ui.main

import android.content.Intent
import com.tech.kata.ui.main.base.TechKataActivityScenarioRule
import org.junit.Test

class MainActivityTest {

    val mainActivity = TechKataActivityScenarioRule<MainActivity>()

    val mainActivityRobot = MainActivityRobot()

     @Test
     fun onSearchClick_seesPeopleWithNameContainCharacterR() {
         mainActivity.launchActivity(MainActivity::class.java)

         mainActivityRobot.seesMainText("R2-D2")
             .seesSearchButton()
     }
 }