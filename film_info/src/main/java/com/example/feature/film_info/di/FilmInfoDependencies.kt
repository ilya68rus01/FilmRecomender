package com.example.feature.film_info.di

import com.example.core.FilmInfoDeps
import com.example.moduleinjector.BaseFeatureDependencies

interface FilmInfoDependencies : BaseFeatureDependencies {
    val contextProvider: FilmInfoDeps
}