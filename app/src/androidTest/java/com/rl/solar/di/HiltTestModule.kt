package com.rl.solar.di

import com.rl.solar.data.FakeRepository
import com.rl.solar.core.Planet
import com.rl.solar.core.SolarAbstractModule
import com.rl.solar.data.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
  components = [SingletonComponent::class],
  replaces = [SolarAbstractModule::class]
)
abstract class HiltTestModule {
  @Binds
  @Singleton
  abstract fun bindFakeRepository(impl: FakeRepository): Repository<Planet>
}
