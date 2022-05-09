package com.rl.solar.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.SmallTest
import com.rl.solar.fragments.PlanetListFragment
import com.rl.solar.core.SolarAbstractModule
import com.rl.solar.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@SmallTest
@UninstallModules(SolarAbstractModule::class)
class PlanetListTest {
  @get:Rule
  val rule = HiltAndroidRule(this)

  @Before
  fun setup() {
    rule.inject()
  }

  @Test
  fun i_can_see_fraggle() {
    launchFragmentInHiltContainer<PlanetListFragment> { }
    onView(withText("Fraggle")).check(matches(isDisplayed()))
  }

  @Test
  fun i_can_see_rock() {
    launchFragmentInHiltContainer<PlanetListFragment> { }
    onView(withText("Rock")).check(matches(isDisplayed()))
  }

  @Test
  fun i_cannot_see_earth() {
    launchFragmentInHiltContainer<PlanetListFragment> { }
    onView(withText("Earth")).check(doesNotExist())
  }
}
