package com.example.shownew.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shownew.NewFilmsViewModel
import com.example.shownew.di.ViewModelFactory
import com.example.shownew.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NewFilmsViewModel::class)
    internal abstract fun bindShowNewFilmsViewModel(showNewFilmsViewModel: NewFilmsViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}