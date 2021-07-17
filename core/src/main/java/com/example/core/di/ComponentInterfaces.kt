package com.example.core.di

import com.example.core.App
import com.example.core.TMDbRepo.TMDbRepo

interface ApplicationProvider :
    MainToolsProvider,
    RepoProvider

interface MainToolsProvider {
    fun provideContext(): App
}

interface RepoProvider {
    fun provideTMDbRepo(): TMDbRepo
}