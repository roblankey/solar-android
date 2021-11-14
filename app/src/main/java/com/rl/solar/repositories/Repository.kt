package com.rl.solar.repositories

import com.rl.solar.core.Planet
import com.rl.solar.database.SolarDao
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

interface Repository<T> {
    fun get(id: Long): Flow<T>
    fun getAll(): Flow<List<T>>
}

@Singleton
class PlanetRepository @Inject constructor(private val dao: SolarDao) : Repository<Planet> {
    override fun get(id: Long): Flow<Planet> = dao.getPlanet(id)
    override fun getAll(): Flow<List<Planet>> = dao.getPlanets()
}
