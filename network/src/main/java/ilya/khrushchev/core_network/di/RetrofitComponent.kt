package ilya.khrushchev.core_network.di

import dagger.Component
import ilya.khrushchev.core_network.TMDbApi

interface NetworkProvider {
    fun providerNewtwork(): TMDbApi
}

@Component(modules = [NetworkModule::class])
interface RetrofitComponent : NetworkProvider