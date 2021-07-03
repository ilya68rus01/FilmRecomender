package khrushchev.ilya.filmrecomender.di.components

import com.example.core.App
import com.example.core.di.ApplicationProvider
import com.example.core.di.MainToolsProvider
import com.example.core.di.RepoProvider
import com.example.repo.di.RepoComponent
import dagger.Component
import khrushchev.ilya.filmrecomender.di.ApplicationScope
import khrushchev.ilya.filmrecomender.di.modules.ViewModelModule

@ApplicationScope
@Component(
    modules = [ViewModelModule::class],
    dependencies = [
        MainToolsProvider::class,
        RepoProvider::class
    ]
)
interface ApplicationComponent : ApplicationProvider {
    fun inject(app: App)

    class Initializer private constructor() {
        companion object {

            fun init(app: App) {
                val mainToolsProvider = MainToolsComponent.Initializer
                    .init(app)

                val repoProvider = RepoComponent.Initializer
                    .init(mainToolsProvider)
            }
        }
    }
}