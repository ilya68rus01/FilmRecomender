package com.example.network.data

import com.example.core.empty

data class Person(
    var birthday: String = String.empty(),
    val knownForDepartment: String?,
    val deathday: String?,
    val id: Int,
    val name: String,
    val alsoKnownAs: List<String>,
    val gender: Gender,
    val biography: String,
    val popularity: Film,
    val placeOfBirth: String?,
    val profilePath: String?,
    val adult: Boolean,
    val imdbId: String,
    val homepage: String?
)