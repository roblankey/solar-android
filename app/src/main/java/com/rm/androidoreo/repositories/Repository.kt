package com.rm.androidoreo.repositories

import com.rm.androidoreo.R
import com.rm.androidoreo.solar.Planet
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface Repository<T> {
    fun get(id: Int): Flow<T?>
    fun getAll(): Flow<List<T>>
}

class PlanetRepository @Inject constructor() : Repository<Planet> {
    override fun get(id: Int): Flow<Planet?> = flowOf(
        planets.firstOrNull { planet -> planet.id == id }
    )

    override fun getAll(): Flow<List<Planet>> = flowOf(planets.toList())

    // todo: replace with service calls & retrofit
    companion object {
        val planets: HashSet<Planet> = hashSetOf(
            Planet(id = 1, name = "Mercury", image = R.drawable.ic_planet_mercury),
            Planet(id = 2, name = "Venus", image = R.drawable.ic_planet_venus),
            Planet(id = 3, name = "Earth", image = R.drawable.ic_planet_earth),
            Planet(id = 4, name = "Mars", image = R.drawable.ic_planet_mars),
            Planet(id = 5, name = "Jupiter", image = R.drawable.ic_planet_jupiter),
            Planet(id = 6, name = "Saturn", image = R.drawable.ic_planet_saturn),
            Planet(id = 7, name = "Uranus", image = R.drawable.ic_planet_uranus),
            Planet(id = 8, name = "Neptune", image = R.drawable.ic_planet_neptune),
            Planet(id = 9, name = "Pluto", image = R.drawable.ic_planet_pluto)
        )
    }
}
