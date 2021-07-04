package khrushchev.ilya.filmrecomender.di.components

import com.example.core.di.ApplicationProvider
import com.example.core.di.MainToolsProvider
import com.example.core.di.RepoProvider
import com.example.core.di.ShowNewFilmsProvider
import com.example.repo.di.RepoComponent
import com.example.shownew.di.component.ShowNewExportComponent
import dagger.Component
import khrushchev.ilya.filmrecomender.Application
import khrushchev.ilya.filmrecomender.di.ApplicationScope

@ApplicationScope
@Component(
    dependencies = [
        MainToolsProvider::class,
        RepoProvider::class,
        ShowNewFilmsProvider::class
    ]
)
interface ApplicationComponent : ApplicationProvider {
    fun inject(app: Application)

    class Initializer private constructor() {
        companion object {

            fun init(app: Application): ApplicationComponent {
                val mainToolsProvider = MainToolsComponent.Initializer
                    .init(app)

                val repoProvider = RepoComponent.Initializer
                    .init(mainToolsProvider)

                val showNewFilmsProvider = ShowNewExportComponent.Initializer
                    .init(mainToolsProvider)

                return DaggerApplicationComponent.builder()
                    .mainToolsProvider(mainToolsProvider)
                    .repoProvider(repoProvider)
                    .showNewFilmsProvider(showNewFilmsProvider)
                    .build()
            }
        }
    }
}