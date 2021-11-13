package com.rl.solar.browser.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rl.solar.repositories.Repository
import com.rl.solar.core.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlanetDetailViewModel @Inject constructor(
    repository: Repository<Planet>,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val planetId: Int = savedStateHandle.get<Int>(PLANET_ID_SAVED_STATE_KEY)!!
    var planet: LiveData<Planet?> = repository.get(planetId).asLiveData()

    companion object {
        private const val PLANET_ID_SAVED_STATE_KEY = "planetId"
    }
}
