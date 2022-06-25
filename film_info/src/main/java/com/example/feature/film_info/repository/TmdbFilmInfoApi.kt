package com.example.feature.film_info.repository

import com.example.core.data.Film
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbFilmInfoApi {

    @GET("3/movie/{filmId}?language=ru")
    fun getFilmInfo(@Path("filmId")filmId: Int): Single<Film>
}