package com.rm.androidoreo.solar.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rm.androidoreo.repositories.Repository
import com.rm.androidoreo.solar.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlanetListViewModel @Inject constructor(repository: Repository<Planet>) : ViewModel() {
    var planets: LiveData<List<Planet>> = repository.getAll().asLiveData()
}
