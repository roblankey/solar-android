package com.rm.androidoreo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rm.androidoreo.repositories.HiltDemoRepository
import com.rm.androidoreo.repositories.entities.HiltDemo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HiltDemoViewModel @Inject constructor(
    repository: HiltDemoRepository
) : ViewModel() {
    private val _hiltDemo = MutableLiveData<HiltDemo>()
    val hiltDemo: LiveData<HiltDemo> = _hiltDemo

    init {
        viewModelScope.launch {
            _hiltDemo.value = repository.getHiltDemo()
        }
    }
}
