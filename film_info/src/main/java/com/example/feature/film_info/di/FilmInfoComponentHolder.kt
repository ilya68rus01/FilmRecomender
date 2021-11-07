package com.example.feature.film_info.di

import com.example.feature.film_info.di.component.DaggerFilmInfoComponent
import com.example.feature.film_info.di.component.FilmInfoComponent
import com.example.moduleinjector.BaseFeatureApi
import com.example.moduleinjector.ComponentHolder
import com.example.moduleinjector.ComponentHolderDelegate

interface FilmInfoApi : BaseFeatureApi {
}

object FilmInfoComponentHolder : ComponentHolder<FilmInfoApi, FilmInfoDependencies> {

    private val componentHolderDelegate =
        ComponentHolderDelegate<FilmInfoApi, FilmInfoDependencies, FilmInfoComponent> {
            DaggerFilmInfoComponent
                .factory()
                .create(it)
        }

    override var dependenciesProvider by componentHolderDelegate::dependenciesProvider

    override fun get(): FilmInfoApi =
        componentHolderDelegate.get()

    internal fun getComponent(): FilmInfoComponent =
        componentHolderDelegate.getComponentImpl()
}
