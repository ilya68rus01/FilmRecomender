package com.example.feature.film_info.repository

import com.example.feature.film_info.FilmInfo
import io.reactivex.rxjava3.core.Single

/**
 * Источник данных предоставляющий полную информаци о фильме по id
 */
interface FilmInfoDataSource {
    fun getFilm(filmId: Int): Single<FilmInfo>
}