package com.rl.solar.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.rl.solar.core.Planet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FakeRepository @Inject constructor() : Repository<Planet> {
  private var dao: SolarDao
  private var db: SolarDatabase

  init {
    val context = ApplicationProvider.getApplicationContext<Context>()
    db = Room.inMemoryDatabaseBuilder(context, SolarDatabase::class.java)
      .allowMainThreadQueries().build()

    dao = db.solarDao()
    dao.addPlanets(
      Planet(98, "Fraggle"),
      Planet(99, "Rock")
    )
  }

  override fun get(id: Long): Flow<Planet?> = dao.getPlanet(id)
  override fun getAll(): Flow<List<Planet>> = dao.getPlanets()
}
