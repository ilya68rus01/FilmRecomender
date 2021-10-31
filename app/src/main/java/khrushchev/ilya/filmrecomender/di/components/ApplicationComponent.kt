package khrushchev.ilya.filmrecomender.di.components

import com.example.core.AppProvider
import com.example.core.ContextProvider
import com.example.core.DaggerContextComponent
import com.example.moduleinjector.BaseFeatureApi
import dagger.Component
import khrushchev.ilya.filmrecomender.FilmRecomenderApp
import khrushchev.ilya.filmrecomender.di.ApplicationScope

@ApplicationScope
@Component(
    dependencies = [
        ContextProvider::class
    ]
)
interface ApplicationComponent : BaseFeatureApi, AppProvider {

    fun inject(app: FilmRecomenderApp)

    class Builder {
        companion object {
            fun build(app: FilmRecomenderApp): ApplicationComponent {
                val contextProvider = DaggerContextComponent.factory().create(app)
                return DaggerApplicationComponent.builder()
                    .contextProvider(contextProvider)
                    .build()
            }
        }
    }
}