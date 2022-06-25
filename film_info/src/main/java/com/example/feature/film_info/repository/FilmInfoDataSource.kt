package com.example.feature.film_info.repository

import com.example.core.data.Film
import io.reactivex.rxjava3.core.Single

/**
 * Источник данных предоставляющий полную информаци о фильме по id
 */
interface FilmInfoDataSource {
    fun getFilm(filmId: Int): Single<Film>
}