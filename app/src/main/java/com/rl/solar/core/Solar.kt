package com.rl.solar.core

import androidx.room.*

@Entity(
  tableName = "moons",
  foreignKeys = [
    ForeignKey(
      entity = Planet::class, parentColumns = ["id"], childColumns = ["planet_id"],
      onDelete = 2
    )
  ],
  indices = [Index("planet_id")]
)
data class Moon(
  @PrimaryKey(autoGenerate = true) val id: Long,
  val name: String,
  @ColumnInfo(name = "planet_id") val planetId: Long
) {
  @ColumnInfo(name = "distance_from_planet") var distanceFromPlanet: Long? = null
}

@Entity(tableName = "planets")
data class Planet(
  @PrimaryKey(autoGenerate = true) val id: Long,
  val name: String
) {
  // resource id of planet svg
  @Ignore var image: Int? = null
  var stub: String? = null

  // orbital characteristics
  var aphelion: Float? = null
  var perihelion: Float? = null
  @ColumnInfo(name = "orbital_period") var orbitalPeriod: Float? = null

  // physical characteristics
  @ColumnInfo(name = "mean_radius") var meanRadius: Long? = null
  var mass: Long? = null
}
