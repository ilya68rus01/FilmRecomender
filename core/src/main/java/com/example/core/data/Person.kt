package com.example.core.data

data class Person(
    val birthday: String?,
    val known_for_department: String?,
    val deathday: String?,
    val id: Int,
    val name: String,
    val also_known_as: List<String>,
    val gender: Gender,
    val biography: String,
    val popularity: Film,
    val place_of_birth: String?,
    val profile_path: String?,
    val adult: Boolean,
    val imdb_id: String,
    val homepage: String?
)