package com.example.shownew.ui

import androidx.lifecycle.ViewModel
import com.example.core.data.Film
import com.example.shownew.repository.NetworkRepository
import com.example.shownew.router.NavCommand
import com.example.shownew.router.NewFilmsFragmentRouter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class NewFilmsViewModel @Inject constructor(
    private val repository: NetworkRepository,
    private val router: NewFilmsFragmentRouter
) : ViewModel() {

    private val disposable: CompositeDisposable

    private val _newFilms = MutableStateFlow<List<Film>>(emptyList())
    val newFilms get() = _newFilms.asStateFlow()

    private val _navCommand = MutableSharedFlow<NavCommand>(0,1,BufferOverflow.DROP_OLDEST)
    val navCommand get() = _navCommand.asSharedFlow()

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

    fun openFilm(filmId: Int) {
        _navCommand.tryEmit(router.navigateToFilmInfo(filmId))
    }
}