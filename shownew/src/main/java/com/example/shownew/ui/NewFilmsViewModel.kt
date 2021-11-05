package com.example.shownew.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.core.data.Film
import com.example.core.data.Page
import com.example.shownew.repository.KeyInterceptor
import com.example.shownew.repository.NetworkRepository
import com.example.shownew.repository.NetworkRepositoryImpl
import com.example.shownew.repository.TmdbNoveltyApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class NewFilmsViewModel @Inject constructor(
) : ViewModel() {

    private val TMDB_BASE_URL = "https://api.themoviedb.org/"

    val repo: NetworkRepository = NetworkRepositoryImpl(
        Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(KeyInterceptor()).build())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbNoveltyApi::class.java)
    )

    private val _newFilmsLiveData = liveData<Page<Film>> {
        repo.getUpComing()
            .blockingGet()
    } as MutableLiveData
    val newFilmsLiveData get() = _newFilmsLiveData

    private val disposable: CompositeDisposable = CompositeDisposable()

    fun getNewFilms(page: Int = 0) {
        repo.getUpComing(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { newFilms -> _newFilmsLiveData.value = newFilms }
            .let(disposable::add)
    }
}