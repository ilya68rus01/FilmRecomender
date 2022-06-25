package com.example.feature.film_info.di.module

import com.example.feature.film_info.repository.FilmInfoDataSource
import com.example.feature.film_info.repository.FilmInfoDataSourceImpl
import com.example.feature.film_info.repository.KeyInterceptor
import com.example.feature.film_info.repository.TmdbFilmInfoApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class FilmInfoModule {
    private val TMDB_BASE_URL = "https://api.themoviedb.org/"

    @Provides
    fun provideApiKeyInterceptor(): Interceptor =
        KeyInterceptor()

    @Provides
    fun provideOkHttpClient(
        apiKeyInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .build()

    @Provides
    fun provideCallAdapterFactory(): CallAdapter.Factory =
        RxJava3CallAdapterFactory.create()

    @Provides
    fun provideConverterFactory(): Converter.Factory =
        GsonConverterFactory.create()

    @Provides
    fun provideRetrofit(
        httpClient: OkHttpClient,
        callAdapter: CallAdapter.Factory,
        converter: Converter.Factory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .client(httpClient)
            .addCallAdapterFactory(callAdapter)
            .addConverterFactory(converter)
            .build()

    @Provides
    fun provideTmdbNoveltyApi(retrofit: Retrofit): TmdbFilmInfoApi =
        retrofit.create(TmdbFilmInfoApi::class.java)

    @Provides
    fun provideFilmInfoDataSource(
        api: TmdbFilmInfoApi
    ): FilmInfoDataSource =
        FilmInfoDataSourceImpl(api)
}