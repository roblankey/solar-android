package com.rl.solar.views

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.SmallTest
import com.rl.solar.core.SolarModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

@HiltAndroidTest
@SmallTest
@UninstallModules(SolarModule::class)
class SolarActivityTest {
    private val hiltRule = HiltAndroidRule(this)
    private val scenarioRule = ActivityScenarioRule(SolarActivity::class.java)

    @get:Rule
    val rule: RuleChain = RuleChain
        .outerRule(hiltRule)
        .around(scenarioRule)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun the_application_launches_and_i_can_see_fraggle_rock() {
        onView(withText("Fraggle")).check(matches(isDisplayed()))
        onView(withText("Rock")).check(matches(isDisplayed()))
    }

    @Test
    fun the_application_launches_and_i_cannot_see_boring_stuff() {
        onView(withText("Earth")).check(doesNotExist())
    }
}
