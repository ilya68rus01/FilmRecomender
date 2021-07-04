package com.example.core.TMDbRepo

import com.example.core.data.Film
import com.example.core.data.Page
import io.reactivex.rxjava3.core.Single

interface TMDbRepo {
    fun getNewFilms(page: Int): Single<Page<Film>>
}