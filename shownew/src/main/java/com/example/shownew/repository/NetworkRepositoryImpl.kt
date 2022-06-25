package com.example.shownew.repository

import com.example.core.data.Film
import com.example.core.data.Page
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class NetworkRepositoryImpl(
    private val api: TmdbNoveltyApi
) : NetworkRepository {

    override fun getUpComing(page: Int): Single<List<Film>> =
        api.getUpComing(page)
            .subscribeOn(Schedulers.io())
            .map { it.results }
}