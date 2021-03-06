package com.rl.solar.data

import androidx.room.*
import com.rl.solar.core.Moon
import com.rl.solar.core.Planet
import kotlinx.coroutines.flow.Flow

@Dao
interface SolarDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun addPlanets(vararg planet: Planet)

  @Query("SELECT * FROM planets ORDER BY id")
  fun getPlanets(): Flow<List<Planet>>

  @Query("SELECT * FROM planets WHERE id = :planetId")
  fun getPlanet(planetId: Long): Flow<Planet?>
}

@Database(entities = [Planet::class, Moon::class], version = 1)
abstract class SolarDatabase : RoomDatabase() {
  abstract fun solarDao(): SolarDao
}
