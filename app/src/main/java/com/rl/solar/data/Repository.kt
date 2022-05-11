package com.rl.solar.data

import com.rl.solar.R
import com.rl.solar.core.Planet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface Repository<T> {
  fun get(id: Long): Flow<T?>
  fun getAll(): Flow<List<T>>
}

class PlanetRepository @Inject constructor(private val dao: SolarDao) : Repository<Planet> {
  override fun get(id: Long): Flow<Planet?> = dao.getPlanet(id).map {
    it?.apply {
      image = getImage(name)
    }
  }

  override fun getAll(): Flow<List<Planet>> = dao.getPlanets().map { planets ->
    planets.map {
      it.apply {
        image = getImage(name)
      }
    }
  }

  private fun getImage(name: String): Int = when (name) {
    "Mercury" -> R.drawable.ic_planet_mercury
    "Venus" -> R.drawable.ic_planet_venus
    "Earth" -> R.drawable.ic_planet_earth
    "Mars" -> R.drawable.ic_planet_mars
    "Jupiter" -> R.drawable.ic_planet_jupiter
    "Saturn" -> R.drawable.ic_planet_saturn
    "Uranus" -> R.drawable.ic_planet_uranus
    "Neptune" -> R.drawable.ic_planet_neptune
    "Pluto" -> R.drawable.ic_planet_pluto
    else -> R.drawable.ic_planet_unknown
  }
}
