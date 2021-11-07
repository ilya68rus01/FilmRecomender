package com.example.feature.film_info.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature.film_info.di.ViewModelFactory
import com.example.feature.film_info.di.ViewModelKey
import com.example.feature.film_info.ui.FilmInfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FilmInfoViewModel::class)
    internal abstract fun bindShowNewFilmsViewModel(showNewFilmsViewModel: FilmInfoViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}