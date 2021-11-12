package com.rm.androidoreo.solar.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rm.androidoreo.repositories.PlanetRepository
import com.rm.androidoreo.solar.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlanetDetailViewModel @Inject constructor(
    repository: PlanetRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val planetId: Int = savedStateHandle.get<Int>(PLANET_ID_SAVED_STATE_KEY)!!
    var planet: LiveData<Planet?> = repository.get(planetId).asLiveData()

    companion object {
        private const val PLANET_ID_SAVED_STATE_KEY = "planetId"
    }
}
