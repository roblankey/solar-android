package com.rm.androidoreo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rm.androidoreo.repositories.Repository
import com.rm.androidoreo.repositories.entities.SolarEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SolarViewModel @Inject constructor(
    repository: Repository<SolarEntity>
) : ViewModel() {
    private val _solarItem = MutableLiveData<SolarEntity>()
    val solarItem: LiveData<SolarEntity> = _solarItem

    private val _solarList = MutableLiveData<List<SolarEntity>>()
    val solarList: LiveData<List<SolarEntity>> = _solarList
}
