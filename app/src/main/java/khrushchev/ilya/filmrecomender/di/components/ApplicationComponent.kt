package khrushchev.ilya.filmrecomender.di.components

import dagger.Component
import khrushchev.ilya.filmrecomender.di.ApplicationScope
import khrushchev.ilya.filmrecomender.di.modules.ViewModelModule

@ApplicationScope
@Component(
    modules = [ViewModelModule::class]
)
interface AppComponent {
}