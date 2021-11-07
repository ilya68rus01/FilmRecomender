package com.example.feature.film_info.di.component

import com.example.feature.film_info.di.FilmInfoApi
import com.example.feature.film_info.di.FilmInfoDependencies
import com.example.feature.film_info.di.module.FilmInfoModule
import com.example.feature.film_info.ui.FilmInfoFragment
import dagger.Component

@Component(
    modules = [
        FilmInfoModule::class
    ],
    dependencies = [
        FilmInfoDependencies::class
    ]
)
interface FilmInfoComponent : FilmInfoApi, FilmInfoDependencies {

    fun inject(fragment: FilmInfoFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: FilmInfoDependencies): FilmInfoComponent
    }
}