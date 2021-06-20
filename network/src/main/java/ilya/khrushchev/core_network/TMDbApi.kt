package ilya.khrushchev.core_network

import ilya.khrushchev.core_network.data.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.awt.Image

interface TMDbApi {

    @GET("https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg")
    fun getImage(): Single<Image>

    @GET("https://api.themoviedb.org/3/movie/{id}?api_key=05dcb0eb78c196777f8b4b1b861d56a0&language=ru")
    fun getFilm(@Path("id") filmId: Int): Single<Film>

    @GET("https://api.themoviedb.org/3/movie/popular?api_key=05dcb0eb78c196777f8b4b1b861d56a0&language=ru&page={page}")
    fun getPopular(@Path("page") page: Int): Single<Page<Film>>

    @GET("https://api.themoviedb.org/3/movie/top_rated?api_key=05dcb0eb78c196777f8b4b1b861d56a0&language=ru&page={page}")
    fun getTopRated(@Path("page") page: Int): Single<Page<Film>>

    @GET("https://api.themoviedb.org/3/movie/upcoming?api_key=05dcb0eb78c196777f8b4b1b861d56a0&language=ru&page={page}")
    fun getUpComing(@Path("page") page: Int): Single<Page<Film>>

    @GET("https://api.themoviedb.org/3/person/{id}?api_key=05dcb0eb78c196777f8b4b1b861d56a0&language=ru")
    fun getPersonById(@Path("id") id: Int): Single<Person>

    @GET("https://api.themoviedb.org/3/search/movie?api_key=05dcb0eb78c196777f8b4b1b861d56a0&language=ru&query={query}")
    fun findMovieByName(@Query("query") query: String): Single<Page<Film>>

    @GET("https://api.themoviedb.org/3/search/person?api_key=05dcb0eb78c196777f8b4b1b861d56a0&language=ru&query={query}")
    fun findPersonByName(@Query("query") query: String): Single<Page<Person>>

    @GET("https://api.themoviedb.org/3/search/tv?api_key=05dcb0eb78c196777f8b4b1b861d56a0&language=ru&page=1&query={query}")
    fun findTVShow(@Query("query") query: String): Single<Page<TVShow>>
}