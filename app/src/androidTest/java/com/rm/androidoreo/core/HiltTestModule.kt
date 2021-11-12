package com.rm.androidoreo.core

import com.rm.androidoreo.FakeRepository
import com.rm.androidoreo.repositories.Repository
import com.rm.androidoreo.solar.Planet
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
