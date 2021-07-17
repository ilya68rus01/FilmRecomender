package com.example.core.data

data class LastEpisodeToAir(
    val airDate: String,
    val episodeNumber: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val productionCode: String,
    val seasonNumber: Int,
    val stillPath: String?,
    val voteAverage: Float,
    val voteCount: Int
)
