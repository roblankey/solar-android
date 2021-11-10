package com.rm.androidoreo.repositories.entities

// https://jsonplaceholder.typicode.com/users
data class SolarEntity(
    val id: Int,
    val name: String,
    val userName: String,
    val email: String,

    // https://jsonplaceholder.typicode.com/users/{id}/todos
    val planets: List<PlanetEntity> = emptyList()
)

// https://jsonplaceholder.typicode.com/todos
data class PlanetEntity(val id: Int, val title: String, val completed: Boolean, val userId: Int?)
