package khrushchev.ilya.filmrecomender

import android.app.Application
import com.example.core.ShowNewDeps
import com.example.moduleinjector.DependencyHolder1
import com.example.shownew.di.ShowNewComponentHolder
import com.example.shownew.di.ShowNewDependencies
import khrushchev.ilya.filmrecomender.di.components.ApplicationComponent
import khrushchev.ilya.filmrecomender.di.components.ApplicationComponent.Builder.Companion.build

class FilmRecomenderApp : Application() {

    companion object {
        lateinit var instance: FilmRecomenderApp
            private set

        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        instance = this

        appComponent = build(this).apply {
            inject(this@FilmRecomenderApp)
        }
        super.onCreate()

        connectModules()
    }

    private fun connectModules() {
        ShowNewComponentHolder.dependenciesProvider = {
            DependencyHolder1<ApplicationComponent, ShowNewDependencies>(
                appComponent
            ) { holder, appComponent ->
                object : ShowNewDependencies {
                    override val contextProvider: ShowNewDeps = appComponent
                    override val dependencyHolder = holder
                }
            }.dependencies
        }
    }
}