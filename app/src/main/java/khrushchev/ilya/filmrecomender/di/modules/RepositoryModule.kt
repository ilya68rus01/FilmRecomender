package khrushchev.ilya.filmrecomender.di.modules

import dagger.Module
import dagger.Provides
import khrushchev.ilya.filmrecomender.repository.Repository
import khrushchev.ilya.filmrecomender.repository.RepositoryMediator

@Module
abstract class RepositoryModule {
    @Provides
    fun provideRepositoryMediator(): Repository = RepositoryMediator()
}