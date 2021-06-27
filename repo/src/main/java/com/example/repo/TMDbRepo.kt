package com.example.repo

import com.example.core.TMDbRepo.TMDbRepo
import ilya.khrushchev.core_network.TMDbApi
import javax.inject.Inject

class TMDbRepoImpl @Inject constructor(
    val client: TMDbApi,
) : TMDbRepo {
    override fun getNewFilms(page: Int) {
        client.getUpComing(page)
    }
}