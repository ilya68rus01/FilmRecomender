package com.example.shownew.repository

import com.example.core.data.Film
import com.example.core.data.Page
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbNoveltyApi {

    @GET("3/movie/upcoming?language=ru&page=pageNumber")
    fun getUpComing(@Query("pageNumber") page: Int): Single<Page<Film>>
}