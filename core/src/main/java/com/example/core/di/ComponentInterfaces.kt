package com.example.core.di

import com.example.core.TMDbRepo.TMDbRepo

interface ApplicationProvider :
        RepoProvider

interface RepoProvider {
    fun provideTMDbRepo() : TMDbRepo
}