package khrushchev.ilya.filmrecomender.repository.remote

import android.media.Image
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitApi {

    @GET("https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg")
    fun getImage(): Single<Image>

//    @GET("https://api.themoviedb.org/3/movie/<id>?api_key=05dcb0eb78c196777f8b4b1b861d56a0&lang=ru")
//    fun getFilm():Single<Film>
}