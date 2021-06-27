package com.example.repo.di

import com.example.core.di.RepoProvider
import dagger.Component
import ilya.khrushchev.core_network.di.NetworkProvider

@Component(
    dependencies = [NetworkProvider::class],
    modules = [RepoModule::class]
)
interface RepoComponent : RepoProvider {
    class Initializer private constructor() {
        companion object {
//            fun init():RepoProvider {
//                val networkProvider = DaggerRetrofitComponent
//            }
        }
    }
}