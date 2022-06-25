package com.example.feature.film_info.repository

import com.example.feature.film_info.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class KeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalUrl = request.url
        val urlWithKey = originalUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()
        val requestBuilder = request.newBuilder()
            .url(urlWithKey)
        val requestWithKey = requestBuilder.build();
        return chain.proceed(requestWithKey)
    }
}