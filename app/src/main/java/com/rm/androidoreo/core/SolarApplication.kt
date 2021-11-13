package com.rl.solar.core

import android.app.Application
import com.rl.solar.repositories.PlanetRepository
import com.rl.solar.repositories.Repository
import com.rl.solar.Planet
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
