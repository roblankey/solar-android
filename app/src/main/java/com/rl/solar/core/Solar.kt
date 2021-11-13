package com.rl.solar.core

// e.g. Europa
data class Moon(
    val id: Int,
    val name: String
)

// e.g. Jupiter
data class Planet(
    val id: Int,
    val name: String,
    val image: Int? = null
)

// e.g. Solar
data class SolarSystem(
    val id: Int,
    val name: String,
    val planets: List<Planet> = emptyList()
)

// e.g. Milky Way
data class Galaxy(
    val id: Int,
    val name: String,
    val systems: List<SolarSystem> = emptyList()
)
