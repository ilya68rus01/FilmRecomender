package com.example.shownew.di.module

import com.example.shownew.repository.KeyInterceptor
import com.example.shownew.repository.NetworkRepository
import com.example.shownew.repository.NetworkRepositoryImpl
import com.example.shownew.repository.TmdbNoveltyApi
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
class ShowNewModule {

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
    fun provideTmdbNoveltyApi(retrofit: Retrofit): TmdbNoveltyApi =
        retrofit.create(TmdbNoveltyApi::class.java)

    @Provides
    fun provideRepository(
        api: TmdbNoveltyApi
    ): NetworkRepository =
        NetworkRepositoryImpl(api)


}