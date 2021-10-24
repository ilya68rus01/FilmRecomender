package com.example.shownew.ui

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class NewFilmsViewModel @Inject constructor(
) : ViewModel() {

//    private val _newFilmsLiveData = liveData<Page<Film>> {
//        repo.getNewFilms(1)
//            .subscribeOn(Schedulers.io())
//            .blockingGet()
//    } as MutableLiveData
//    val newFilmsLiveData get() = _newFilmsLiveData
//
//    private val disposable: CompositeDisposable = CompositeDisposable()
//
//    fun getNewFilms(page: Int) {
//        repo.getNewFilms(page)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe { newFilms -> _newFilmsLiveData.value = newFilms }
//            .let(disposable::add)
//    }
}