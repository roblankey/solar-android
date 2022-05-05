package com.rl.solar.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.google.common.truth.Truth.assertThat
import com.rl.solar.MainCoroutineRule
import com.rl.solar.browser.viewmodels.PlanetDetailViewModel
import com.rl.solar.core.Planet
import com.rl.solar.getOrAwaitValue
import com.rl.solar.repositories.PlanetRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PlanetDetailViewModelTest {
  @get:Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  @ExperimentalCoroutinesApi
  @get:Rule
  var mainCoroutineRule = MainCoroutineRule()

  private lateinit var repository: PlanetRepository

  @Before
  fun setup() {
    repository = mockk()
  }

  @ExperimentalStdlibApi
  @Test
  fun `view model can get planet details from repository`() {
    // g
    val planet = Planet(0, "Burgundy")
    every { repository.get(0) } returns flowOf(planet)

    val state = mockk<SavedStateHandle>()
    every { state.get<Int>(any()) } returns 0

    val viewModel = PlanetDetailViewModel(repository, state)

    // w
    val result = viewModel.planet.getOrAwaitValue()

    // t
    assertThat(result).isNotNull()
    assertThat(result).isEqualTo(planet)
  }

  @Test
  fun `view model handles null planet from repository`() {
    // g
    every { repository.get(any()) } returns flowOf(null)

    val state = mockk<SavedStateHandle>()
    every { state.get<Int>(any()) } returns 0

    val viewModel = PlanetDetailViewModel(repository, state)

    // w
    val result = viewModel.planet.getOrAwaitValue()

    // t
    assertThat(result).isNull()
  }
}
