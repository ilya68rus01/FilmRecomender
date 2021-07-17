package khrushchev.ilya.filmrecomender.di.components

import com.example.core.App
import com.example.core.di.MainToolsProvider
import dagger.BindsInstance
import dagger.Component

@Component
interface MainToolsComponent : MainToolsProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): MainToolsProvider
    }
}

