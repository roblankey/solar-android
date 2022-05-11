package com.rl.solar.core

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.rl.solar.data.PlanetRepository
import com.rl.solar.data.Repository
import com.rl.solar.data.SolarDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltAndroidApp
class SolarApplication : Application()

@InstallIn(SingletonComponent::class)
@Module
interface SolarAbstractModule {
  @Binds @Singleton
  fun providesPlanetRepository(impl: PlanetRepository): Repository<Planet>
}

@InstallIn(SingletonComponent::class)
@Module
class SolarConcreteModule {
  @Provides
  fun providesSolarDao(database: SolarDatabase) = database.solarDao()

  @Provides
  fun providesSolarDatabase(@ApplicationContext context: Context): SolarDatabase =
    Room.databaseBuilder(context, SolarDatabase::class.java, "Solar")
      .createFromAsset("databases/solar.db")
      .build()
}
