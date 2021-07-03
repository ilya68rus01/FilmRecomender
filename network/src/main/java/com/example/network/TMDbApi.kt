package com.example.network

import com.example.network.data.Film
import com.example.network.data.Page
import com.example.network.data.Person
import com.example.network.data.TVShow
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val KEY = "05dcb0eb78c196777f8b4b1b861d56a0"

interface TMDbApi {

    @GET("https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg")
    fun getImage(): Single<Unit>

    @GET("/movie/{id}?api_key=$KEY&language=ru")
    fun getFilm(@Path("id") filmId: Int): Single<Film>

    @GET("/movie/popular?api_key=$KEY&language=ru&page={page}")
    fun getPopular(@Path("page") page: Int): Single<Page<Film>>

    @GET("/movie/top_rated?api_key=$KEY&language=ru&page={page}")
    fun getTopRated(@Path("page") page: Int): Single<Page<Film>>

    @GET("/movie/upcoming?api_key=$KEY&language=ru&page={page}")
    fun getUpComing(@Path("page") page: Int): Single<Page<Film>>

    @GET("/person/{id}?api_key=$KEY&language=ru")
    fun getPersonById(@Path("id") id: Int): Single<Person>

    @GET("/search/movie?api_key=$KEY&language=ru&query={query}")
    fun findMovieByName(@Query("query") query: String): Single<Page<Film>>

    @GET("/search/person?api_key=$KEY&language=ru&query={query}")
    fun findPersonByName(@Query("query") query: String): Single<Page<Person>>

    @GET("/search/tv?api_key=$KEY&language=ru&page=1&query={query}")
    fun findTVShow(@Query("query") query: String): Single<Page<TVShow>>
}