package com.example.repo.di

import com.example.core.TMDbRepo.TMDbRepo
import com.example.repo.TMDbRepoImpl
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {
    @Binds
    fun bindsMainRepo(impl: TMDbRepoImpl): TMDbRepo
}