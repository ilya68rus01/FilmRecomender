package com.example.network

import com.example.core.data.Film
import com.example.core.data.Person
import com.example.core.data.TVShow
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class TMDbRequests @Inject constructor(
    val api: TMDbApi
) {

    fun loadFilmById(filmId: Int): Single<Film> {
        return api
            .getFilm(filmId)
            .subscribeOn(Schedulers.io())
    }

    fun loadPopular(page: Int): Single<List<Film>> {
        return api
            .getPopular(page)
            .subscribeOn(Schedulers.io())
            .map { it.results }
    }

    fun loadTopRated(page: Int): Single<List<Film>> {
        return api
            .getTopRated(page)
            .subscribeOn(Schedulers.io())
            .map { it.results }
    }

    fun loadUpComing(page: Int): Single<List<Film>> {
        return api
            .getUpComing(page)
            .subscribeOn(Schedulers.io())
            .map { it.results }
    }

    fun getMovieByName(name: String): Single<List<Film>> {
        return api
            .findMovieByName(name)
            .subscribeOn(Schedulers.io())
            .map { it.results }
    }

    fun getPersonById(id: Int): Single<Person> {
        return api
            .getPersonById(id)
            .subscribeOn(Schedulers.io())
    }

    fun findPersonByName(name: String): Single<List<Person>> {
        return api
            .findPersonByName(name)
            .subscribeOn(Schedulers.io())
            .map { it.results }
    }

    fun findTVShowByName(name: String): Single<List<TVShow>> {
        return api
            .findTVShow(name)
            .subscribeOn(Schedulers.io())
            .map { it.results }
    }
}
