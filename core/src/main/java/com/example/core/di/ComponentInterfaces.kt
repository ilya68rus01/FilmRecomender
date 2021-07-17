package com.example.core.di

import com.example.core.App
import com.example.core.TMDbRepo.TMDbRepo
import com.example.core.actions.ShowNewFilmsAction

interface ApplicationProvider :
    MainToolsProvider,
    ShowNewFilmsProvider,
    RepoProvider

interface MainToolsProvider {
    fun provideContext(): App
}

interface RepoProvider {
    fun provideTMDbRepo(): TMDbRepo
}

interface ShowNewFilmsProvider {
    fun provideShowNewFilmsAction(): ShowNewFilmsAction
}