package ilya.khrushchev.core_network.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ilya.khrushchev.core_network.TMDbRequests
import ilya.khrushchev.core_network.TMDbApi
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

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
        callAdapter: RxJava3CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .addCallAdapterFactory(callAdapter)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    fun provideTMDbApi(retrofit: Retrofit): TMDbApi {
        return retrofit.create(TMDbApi::class.java)
    }

    @Binds
    fun provideTMDbRepository(api: TMDbApi): TMDbRequests {
        return TMDbRequests(api)
    }

}
