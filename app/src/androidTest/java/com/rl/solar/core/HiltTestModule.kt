package com.rl.solar.core

import com.rl.solar.FakeRepository
import com.rl.solar.repositories.Repository
import com.rl.solar.Planet
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [SolarModule::class]
)
abstract class HiltTestModule {
    @Binds
    @Singleton
    abstract fun bindFakeRepository(impl: FakeRepository): Repository<Planet>
}
