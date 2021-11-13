package com.rl.solar.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PlanetRepositoryTest {
    @get:Rule
    var rule = InstantTaskExecutorRule()

    private lateinit var repository: PlanetRepository

    @Before
    fun setup() {
        repository = PlanetRepository()
    }

    @Test
    fun `repository should return milky way planets`() {
        runBlocking {
            repository.getAll().test {
                val result = awaitItem()
                assertThat(result).isNotNull()
                assertThat(result).isNotEmpty()
                awaitComplete()
            }
        }
    }

    @Test
    fun `repository should be able to retrieve pluto`() {
        runBlocking {
            repository.get(9).test {
                val result = awaitItem()
                assertThat(result).isNotNull()
                assertThat(result?.id).isEqualTo(9)
                assertThat(result?.name).isEqualTo("Pluto")
                awaitComplete()
            }
        }
    }
}
