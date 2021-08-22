package com.example.network

import com.example.core.data.Film
import com.example.core.data.Page
import com.example.core.data.Person
import com.example.core.data.TVShow
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface TMDbApi {

    @GET("https://image.tmdb.org/t/p/w500/21M3oZXEuWzO2lURpbLvulxDxaK.jpg")
    fun getImage(): Single<Unit>

    @GET("/movie/{id}?language=ru")
    fun getFilm(@Path("id") filmId: Int): Single<Film>

    @GET("3/movie/popular?language=ru&page=pageNumber")
    fun getPopular(@Query("pageNumber") page: Int): Single<Page<Film>>

    @GET("/movie/top_rated?language=ru&page={page}")
    fun getTopRated(@Path("page") page: Int): Single<Page<Film>>

    @GET("3/movie/upcoming?language=ru&page=pageNumber")
    fun getUpComing(@Query("pageNumber") page: Int): Single<Page<Film>>

    @GET("/person/{id}?language=ru")
    fun getPersonById(@Path("id") id: Int): Single<Person>

    @GET("/search/movie?language=ru&query={query}")
    fun findMovieByName(@Query("query") query: String): Single<Page<Film>>

    @GET("/search/person?language=ru&query={query}")
    fun findPersonByName(@Query("query") query: String): Single<Page<Person>>

    @GET("/search/tv?language=ru&page=1&query={query}")
    fun findTVShow(@Query("query") query: String): Single<Page<TVShow>>
}