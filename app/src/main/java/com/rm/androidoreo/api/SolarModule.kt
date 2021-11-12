package com.rm.androidoreo.api

import com.rm.androidoreo.repositories.PlanetRepository
import com.rm.androidoreo.repositories.Repository
import com.rm.androidoreo.solar.Planet
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class SolarModule {
    @Singleton
    @Binds
    abstract fun bindPlanetRepository(impl: PlanetRepository): Repository<Planet>
}
