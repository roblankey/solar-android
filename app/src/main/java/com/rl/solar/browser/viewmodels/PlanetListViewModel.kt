package com.rl.solar.browser.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rl.solar.R
import com.rl.solar.repositories.Repository
import com.rl.solar.core.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PlanetListViewModel @Inject constructor(repository: Repository<Planet>) : ViewModel() {
    var planets = repository.getAll().map { planets ->
        planets.map { planet -> planet.resolveImageResource() }
    }.asLiveData()
}

fun Planet.resolveImageResource() : Planet {
    this.image = when(this.name) {
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

    return this
}
