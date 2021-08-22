package com.example.repo

import com.example.core.TMDbRepo.TMDbRepo
import com.example.core.data.Film
import com.example.core.data.Page
import com.example.network.TMDbApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TMDbRepoImpl @Inject constructor(
    private val client: TMDbApi,
) : TMDbRepo {
    override fun getNewFilms(page: Int): Single<Page<Film>> =
        client.getUpComing(page)

    override fun getPopular(page: Int): Single<Page<Film>> =
        client.getPopular(page)
}