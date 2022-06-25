package com.example.feature.film_info.ui

import androidx.lifecycle.ViewModel
import com.example.feature.film_info.repository.FilmInfoDataSource
import javax.inject.Inject

class FilmInfoViewModel @Inject constructor(
    private val filmInfoDataSource: FilmInfoDataSource
) : ViewModel() {

}