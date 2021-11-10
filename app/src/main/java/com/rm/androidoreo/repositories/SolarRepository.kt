package com.rm.androidoreo.repositories

import com.rm.androidoreo.repositories.entities.SolarEntity
import javax.inject.Inject

interface Repository<T> {
    fun get(): T
    fun getAll(): List<T>
}

class SolarRepository @Inject constructor() : Repository<SolarEntity> {
    override fun get(): SolarEntity {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<SolarEntity> {
        TODO("Not yet implemented")
    }
}
