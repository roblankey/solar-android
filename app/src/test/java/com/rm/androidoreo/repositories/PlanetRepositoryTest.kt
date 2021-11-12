package com.rm.androidoreo.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotBeEmpty
import org.amshove.kluent.shouldNotBeNull
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
                awaitItem().shouldNotBeNull().shouldNotBeEmpty()
                awaitComplete()
            }
        }
    }

    @Test
    fun `repository should be able to retrieve pluto`() {
        runBlocking {
            repository.get(9).test {
                val result = awaitItem()
                result.shouldNotBeNull()
                result.id.shouldBeEqualTo(9)
                result.name.shouldBeEqualTo("Pluto")

                awaitComplete()
            }
        }
    }
}
