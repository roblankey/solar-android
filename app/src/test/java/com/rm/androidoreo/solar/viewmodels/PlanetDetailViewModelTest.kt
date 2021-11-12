package com.rm.androidoreo.solar.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.rm.androidoreo.MainCoroutineRule
import com.rm.androidoreo.getOrAwaitValue
import com.rm.androidoreo.repositories.PlanetRepository
import com.rm.androidoreo.solar.Planet
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.amshove.kluent.shouldBeEquivalentTo
import org.amshove.kluent.shouldBeNull
import org.amshove.kluent.shouldNotBeNull
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
        result.shouldNotBeNull().shouldBeEquivalentTo(planet)
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
        result.shouldBeNull()
    }
}
