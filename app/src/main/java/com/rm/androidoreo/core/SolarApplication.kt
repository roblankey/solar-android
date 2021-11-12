package com.rm.androidoreo.core

import android.app.Application
import com.rm.androidoreo.repositories.PlanetRepository
import com.rm.androidoreo.repositories.Repository
import com.rm.androidoreo.solar.Planet
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltAndroidApp
class SolarApplication : Application()

@InstallIn(SingletonComponent::class) @Module
abstract class SolarModule {
    @Binds @Singleton
    abstract fun providesPlanetRepository(impl: PlanetRepository): Repository<Planet>
}
