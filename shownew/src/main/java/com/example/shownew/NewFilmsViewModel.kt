package com.example.shownew

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.core.TMDbRepo.TMDbRepo
import com.example.core.data.Film
import com.example.core.data.Page
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class NewFilmsViewModel @Inject constructor(
    private val repo: TMDbRepo
) : ViewModel() {

    private val _newFilmsLiveData = liveData<List<Film>> {
        emptyList<Film>()
    } as MutableLiveData
    val newFilmsLiveData get() = _newFilmsLiveData

    private val _popularFilmsLiveData = liveData<List<Film>> {
        emptyList<Film>()
    } as MutableLiveData
    val popularFilmsLiveData get() = _popularFilmsLiveData

    private val disposable: CompositeDisposable = CompositeDisposable()

    fun updateData() {
        getNewFilms(1)
        getPopularFilms(1)
    }

    fun getNewFilms(page: Int) {
        repo.getNewFilms(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ newFilms ->
                _newFilmsLiveData.value = newFilms.results
            }, {
                it.message?.let { it1 -> Log.d("Error", it1) }
            }
            )
            .let(disposable::add)
    }

    fun getPopularFilms(page: Int) {
        repo.getPopular(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({  popularFilms ->
                _popularFilmsLiveData.value = popularFilms.results
            }, {
                it.message?.let { it1 -> Log.d("Error", it1) }
            }
            )
            .let(disposable::add)
    }
}