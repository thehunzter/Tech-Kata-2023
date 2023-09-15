package com.tech.kata.ui.main.base

import android.app.Activity
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.times
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import org.junit.Assert.*
import org.junit.rules.ExternalResource

class TechKataActivityScenarioRule<T : Activity> : ExternalResource() {

  private lateinit var activityScenario: ActivityScenario<T>

  val scenario: ActivityScenario<T>
    get() = activityScenario

  override fun before() {
    Intents.init()
  }

  override fun after() {
    Intents.release()

    if (this::activityScenario.isInitialized)
      activityScenario.close()
  }

  fun <A:Activity> buildIntent(activity: Class<A>): Intent {
    lateinit var intent: Intent
    activityScenario.onActivity {
      intent = (Intent(it, activity))
    }

    return intent
  }

  fun <A : Activity> checkActivityLaunched(activity: Class<A>) {
    intended(hasComponent(activity.name))
  }

  fun <V> checkIntentHasExtra(key: String, value: V) {
    intended(IntentMatchers.hasExtra(key, value))
  }

  fun <A : Activity> checkActivityLaunched(activity: Class<A>, numTime: Int) {
    intended(hasComponent(activity.name), times(numTime))
  }

  fun <V> checkIntentHasExtra(key: String, value: V, numTime: Int) {
    intended(IntentMatchers.hasExtra(key, value), times(numTime))
  }

  fun <S> checkActivityState(state : S) {
    assertTrue(activityScenario.state == state)
  }

  fun launchActivity(intent: Intent) {
    activityScenario = ActivityScenario.launch(intent)
  }

  fun launchActivity(activityClass: Class<T>) {
    activityScenario = ActivityScenario.launch(activityClass)
  }

}