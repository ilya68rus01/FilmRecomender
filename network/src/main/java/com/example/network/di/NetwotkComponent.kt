package com.example.network.di

import com.example.network.TMDbApi
import dagger.Component

interface NetworkProvider {
    fun providerNetwork(): TMDbApi
}

@Component(
    modules = [
        NetworkModule::class
    ]
)
interface NetworkComponent : NetworkProvider