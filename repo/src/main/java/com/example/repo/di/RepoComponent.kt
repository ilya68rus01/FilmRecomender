package com.example.repo.di

import com.example.core.di.MainToolsProvider
import com.example.core.di.RepoProvider
import com.example.network.di.DaggerNetworkComponent
import com.example.network.di.NetworkProvider
import dagger.Component

@Component(
    dependencies = [
        MainToolsProvider::class,
        NetworkProvider::class
    ],
    modules = [RepoModule::class]
)
interface RepoComponent : RepoProvider {

    class Initializer private constructor() {
        companion object {

            fun init(mainToolsProvider: MainToolsProvider): RepoProvider {
                val networkProvider = DaggerNetworkComponent.builder()
                    .build()

                return DaggerRepoComponent.builder()
                    .mainToolsProvider(mainToolsProvider)
                    .networkProvider(networkProvider)
                    .build()
            }
        }
    }
}