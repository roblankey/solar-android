package com.rl.solar.browser.viewmodels

import androidx.lifecycle.*
import com.rl.solar.core.Planet
import com.rl.solar.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetDetailViewModel @Inject constructor(private val repository: Repository<Planet>) : ViewModel() {
  private val _planet: MutableLiveData<Planet?> = MutableLiveData(null)
  val planet: LiveData<Planet?> = _planet

  fun loadPlanet(id: Long) = viewModelScope.launch {
    repository.get(id).collect { planet ->
      _planet.value = planet
    }
  }
}
