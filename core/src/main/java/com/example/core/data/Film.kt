package com.example.core.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class Film(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: String?,
    val budget: Int,
    @SerializedName("genre_ids") val genres: List<Int>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Float,
    val poster_path: String,
    val production_companies: List<ProductionCompanies>,
    val production_countries: List<ProductionCountries>,
    val release_date: Date,
    val revenue: Int,
    val runtime: Float,
    val spoken_languages: List<SpokenLanguages>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int
)