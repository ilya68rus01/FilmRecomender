package com.example.network.di

import com.example.network.KeyInterceptor
import com.example.network.TMDbApi
import com.example.network.TMDbRequests
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val TMDB_BASE_URL = "https://api.themoviedb.org/3"

@Module
class NetworkModule {

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideCallAdapterFactory(): RxJava3CallAdapterFactory {
        return RxJava3CallAdapterFactory.create()
    }

    @Provides
    fun providesTMDbRetrofit(
        converterFactory: GsonConverterFactory,
        callAdapter: RxJava3CallAdapterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapter)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    fun provideTMDbApi(retrofit: Retrofit): TMDbApi {
        return retrofit.create(TMDbApi::class.java)
    }

    @Provides
    fun provideTMDbRepository(api: TMDbApi): TMDbRequests {
        return TMDbRequests(api)
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(KeyInterceptor()).build();

}
