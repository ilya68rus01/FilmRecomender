package com.example.shownew

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
    val repo: TMDbRepo
) : ViewModel() {

    private val _newFilmsLiveData = liveData<Page<Film>> {
        repo.getNewFilms(1)
            .subscribeOn(Schedulers.io())
            .blockingGet()
    } as MutableLiveData
    val newFilmsLiveData get() = _newFilmsLiveData

    private val disposable: CompositeDisposable = CompositeDisposable()

    fun getNewFilms(page: Int) {
        repo.getNewFilms(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { newFilms -> _newFilmsLiveData.value = newFilms }
            .let(disposable::add)
    }
}