package khrushchev.ilya.filmrecomender

import android.app.Application
import com.example.core.App
import com.example.core.di.ApplicationProvider
import khrushchev.ilya.filmrecomender.di.components.ApplicationComponent

class Application : Application(), App {

    val applicationComponent: ApplicationComponent by lazy {
        ApplicationComponent.Initializer.init(this@Application)
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)
    }

    override fun getAppComponent(): ApplicationProvider = applicationComponent
}