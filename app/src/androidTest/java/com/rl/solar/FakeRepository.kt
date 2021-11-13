package com.rl.solar

import com.rl.solar.repositories.Repository
import com.rl.solar.core.Planet
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeRepository @Inject constructor() : Repository<Planet> {
    private val _planets = listOf(
        Planet(98, "Fraggle", image = R.drawable.ic_planet_unknown),
        Planet(99, "Rock", image = R.drawable.ic_planet_unknown)
    )

    override fun get(id: Int): Flow<Planet?> = flowOf(
        _planets.firstOrNull { planet -> planet.id == id }
    )

    override fun getAll(): Flow<List<Planet>> = flowOf(_planets.toList())
}
