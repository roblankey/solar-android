package com.rl.solar.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.rl.solar.core.Planet
import com.rl.solar.database.SolarDao
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PlanetRepositoryTest {
  @get:Rule
  var rule = InstantTaskExecutorRule()

  private lateinit var repository: PlanetRepository
  private val mockedPlanets = listOf(
    Planet(1, "Fraggle"),
    Planet(2, "Rock")
  )

  @Before
  fun setup() {
    // g
    val dao = mockk<SolarDao>()
    every { dao.getPlanets() } returns flowOf(mockedPlanets)
    every { dao.getPlanet(any()) } returns flowOf(mockedPlanets.first())
    repository = PlanetRepository(dao)
  }

  @Test
  fun `repository should return milky way planets`() {
    runBlocking {
      // w
      repository.getAll().test {
        // t
        val result = awaitItem()
        assertThat(result).isNotNull()
        assertThat(result).isNotEmpty()
        assertThat(result).isEqualTo(mockedPlanets)
        awaitComplete()
      }
    }
  }

  @Test
  fun `repository should be able to retrieve pluto`() {
    runBlocking {
      // w
      repository.get(0).test {
        // t
        val result = awaitItem()
        assertThat(result).isNotNull()
        assertThat(result?.id).isEqualTo(mockedPlanets.first().id)
        assertThat(result?.name).isEqualTo(mockedPlanets.first().name)
        awaitComplete()
      }
    }
  }
}
