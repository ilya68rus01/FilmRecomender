package com.example.shownew.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.core.data.Film
import com.example.shownew.repository.NetworkRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class NewFilmsViewModel @Inject constructor(
    private val repository: NetworkRepository
) : ViewModel() {

    private val _newFilmsLiveData = liveData<List<Film>> {
        repository.getUpComing()
            .blockingGet()
    } as MutableLiveData
    val newFilmsLiveData get() = _newFilmsLiveData

    private val disposable: CompositeDisposable = CompositeDisposable()

    fun getNewFilms(page: Int = 0) {
        repository.getUpComing(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.results }
            .subscribe { newFilms -> _newFilmsLiveData.value = newFilms }
            .let(disposable::add)
    }
}