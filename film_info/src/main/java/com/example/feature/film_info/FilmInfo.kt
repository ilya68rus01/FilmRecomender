package com.example.feature.film_info

import com.example.core.data.Film
import com.example.core.data.ProductionCompanies
import com.example.core.data.ProductionCountries
import com.example.core.data.SpokenLanguages
import com.example.core.extensions.emptyString
import java.util.*

data class FilmInfo(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: String?,
    val budget: Int,
    val genres: List<Int>,
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
) {
    companion object {
        @JvmField
        val EMPTY = FilmInfo(
            true,
            emptyString(),
            emptyString(),
            Int.MIN_VALUE,
            emptyList(),
            emptyString(),
            Int.MIN_VALUE,
            emptyString(),
            emptyString(),
            emptyString(),
            emptyString(),
            Float.MIN_VALUE,
            emptyString(),
            emptyList(),
            emptyList(),
            Date(System.currentTimeMillis()),
            Int.MIN_VALUE,
            Float.MIN_VALUE,
            emptyList(),
            emptyString(),
            emptyString(),
            emptyString(),
            false,
            Float.MIN_VALUE,
            Int.MIN_VALUE
        )
    }
}

fun Film.toFilmInfo() =
    FilmInfo(
        adult,
        backdrop_path,
        belongs_to_collection,
        budget,
        genres,
        homepage,
        id,
        imdb_id,
        original_language,
        original_title,
        overview,
        popularity,
        poster_path,
        production_companies,
        production_countries,
        release_date,
        revenue,
        runtime,
        spoken_languages,
        status,
        tagline,
        title,
        video,
        vote_average,
        vote_count,
    )