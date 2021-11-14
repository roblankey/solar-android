package com.rl.solar.browser.viewmodels

import androidx.lifecycle.*
import com.rl.solar.repositories.Repository
import com.rl.solar.core.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PlanetDetailViewModel @Inject constructor(val repository: Repository<Planet>) : ViewModel() {
    var planet: LiveData<Planet> = MutableLiveData()

    fun loadPlanet(id: Long) {
        planet = repository.get(id).map { it.resolveImageResource() }.asLiveData()
    }
}
