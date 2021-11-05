package com.example.shownew.repository

import okhttp3.Interceptor
import okhttp3.Response

class KeyInterceptor : Interceptor {
    private val KEY = "05dcb0eb78c196777f8b4b1b861d56a0"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalUrl = request.url
        val urlWithKey = originalUrl.newBuilder()
            .addQueryParameter("api_key", KEY)
            .build()
        val requestBuilder = request.newBuilder()
            .url(urlWithKey)
        val requestWithKey = requestBuilder.build();
        return chain.proceed(requestWithKey)
    }
}