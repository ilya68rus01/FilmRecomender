package com.example.feature.film_info.di.component

import com.example.feature.film_info.di.FilmInfoApi
import com.example.feature.film_info.di.FilmInfoDependencies
import com.example.feature.film_info.di.module.FilmInfoModule
import dagger.Component

@Component(
    modules = [
        FilmInfoModule::class
    ],
    dependencies = [
        FilmInfoDependencies::class
    ]
)
interface FilmInfoComponent : FilmInfoApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: FilmInfoDependencies): FilmInfoComponent
    }
}