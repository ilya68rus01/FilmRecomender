package com.example.shownew.repository

import com.example.core.data.Film
import com.example.core.data.Page
import io.reactivex.rxjava3.core.Single

interface NetworkRepository {

    fun getUpComing(page: Int = 1): Single<List<Film>>
}