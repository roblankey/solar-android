package com.rm.androidoreo.solar.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.rm.androidoreo.MainCoroutineRule
import com.rm.androidoreo.getOrAwaitValue
import com.rm.androidoreo.repositories.PlanetRepository
import com.rm.androidoreo.solar.Planet
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PlanetListViewModelTest {
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

    @Test
    fun `view model gets planets from repository`() {
        // g
        val expected = listOf(
            Planet(98, "Fraggle"),
            Planet(99, "Rock"),
        )

        every { repository.getAll() } returns flowOf(expected)
        val viewModel = PlanetListViewModel(repository)

        // w
        val results = viewModel.planets.getOrAwaitValue()

        // t
        assertThat(results).isNotNull()
        assertThat(results).isNotEmpty()
        assertThat(results).containsExactlyElementsIn(expected)
    }
}
