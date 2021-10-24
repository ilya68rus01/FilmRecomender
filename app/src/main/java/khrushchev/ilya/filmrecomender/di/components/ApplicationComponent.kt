package khrushchev.ilya.filmrecomender.di.components

import com.example.moduleinjector.BaseFeatureApi
import com.example.moduleinjector.BaseFeatureDependencies
import dagger.Component
import khrushchev.ilya.filmrecomender.FilmRecomenderApp
import khrushchev.ilya.filmrecomender.di.ApplicationScope

@ApplicationScope
@Component
interface ApplicationComponent : BaseFeatureApi, BaseFeatureDependencies {

    fun inject(app: FilmRecomenderApp)

    class Builder {
        companion object {
            fun build(app: FilmRecomenderApp): ApplicationComponent {
                return DaggerApplicationComponent.builder()
                    .build()
            }
        }
    }
}