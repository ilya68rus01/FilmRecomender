package khrushchev.ilya.filmrecomender.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import khrushchev.ilya.filmrecomender.di.ViewModelFactory
import khrushchev.ilya.filmrecomender.di.ViewModelKey

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ViewModel::class)
    internal abstract fun bindEditPlaceViewModel(editPlaceViewModel: ViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}