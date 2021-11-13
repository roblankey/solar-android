package com.rl.solar.browser.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rl.solar.repositories.Repository
import com.rl.solar.core.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlanetListViewModel @Inject constructor(repository: Repository<Planet>) : ViewModel() {
    var planets: LiveData<List<Planet>> = repository.getAll().asLiveData()
}
