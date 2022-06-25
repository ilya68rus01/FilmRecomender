package com.example.shownew.repository

import com.example.shownew.BuildConfig.TMDB_API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class KeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalUrl = request.url
        val urlWithKey = originalUrl.newBuilder()
            .addQueryParameter("api_key", TMDB_API_KEY)
            .build()
        val requestBuilder = request.newBuilder()
            .url(urlWithKey)
        val requestWithKey = requestBuilder.build();
        return chain.proceed(requestWithKey)
    }
}