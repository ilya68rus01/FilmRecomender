package com.example.feature.film_info.repository

import com.example.feature.film_info.toFilmInfo
import io.reactivex.rxjava3.schedulers.Schedulers

class FilmInfoDataSourceImpl(
    private val tmdbApi: TmdbFilmInfoApi
) : FilmInfoDataSource {

    override fun getFilm(filmId: Int) =
        tmdbApi.getFilmInfo(filmId)
            .subscribeOn(Schedulers.io())
            .map { it.toFilmInfo() }

}