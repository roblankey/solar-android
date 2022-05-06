package com.rl.solar.browser.viewmodels

import androidx.lifecycle.*
import com.rl.solar.core.Planet
import com.rl.solar.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetListViewModel @Inject constructor(repository: Repository<Planet>) : ViewModel() {
  private val _planets: MutableLiveData<List<Planet>> = MutableLiveData()
  val planets: LiveData<List<Planet>> = _planets

  init {
    viewModelScope.launch {
      repository.getAll().collect {
        _planets.value = it
      }
    }
  }
}
