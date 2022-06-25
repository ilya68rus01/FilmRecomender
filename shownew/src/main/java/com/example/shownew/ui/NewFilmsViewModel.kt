package com.example.shownew.ui

import androidx.lifecycle.ViewModel
import com.example.core.data.Film
import com.example.shownew.repository.NetworkRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class NewFilmsViewModel @Inject constructor(
    private val repository: NetworkRepository
) : ViewModel() {

    private val disposable: CompositeDisposable

    private val _newFilms = MutableStateFlow<List<Film>>(emptyList())
    val newFilms get() = _newFilms.asStateFlow()

    init {
        disposable = CompositeDisposable()
        getNewFilms()
    }

    fun getNewFilms(page: Int = 0) {
        repository.getUpComing(page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { newFilms -> _newFilms.tryEmit(newFilms) }
            .let(disposable::add)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}