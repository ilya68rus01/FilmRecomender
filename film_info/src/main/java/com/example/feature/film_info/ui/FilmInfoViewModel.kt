package com.example.feature.film_info.ui

import android.util.Log.e
import androidx.lifecycle.ViewModel
import com.example.feature.film_info.FilmInfo
import com.example.feature.film_info.repository.FilmInfoDataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class FilmInfoViewModel @Inject constructor(
    private val filmInfoDataSource: FilmInfoDataSource
) : ViewModel() {

    private val _filmInfo = MutableStateFlow(FilmInfo.EMPTY)
    val filmInfo get() = _filmInfo.asStateFlow()

    fun initByBundle(filmId: Int) {
        filmInfoDataSource.getFilm(filmId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                _filmInfo::tryEmit
            ) {
                e("Error", "", it)
            }
    }

}