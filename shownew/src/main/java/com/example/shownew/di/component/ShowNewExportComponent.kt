package com.example.shownew.di.component

import com.example.core.actions.ShowNewFilmsAction
import com.example.core.di.MainToolsProvider
import com.example.core.di.ShowNewFilmsProvider
import com.example.shownew.actions.ShowNewFilms
import dagger.Component
import dagger.Module
import dagger.Provides

@Module
class ShowNewExportModule {
    @Provides
    fun provideShowNewFilmsAction(): ShowNewFilmsAction = ShowNewFilms()
}

@Component(
    dependencies = arrayOf(MainToolsProvider::class),
    modules = arrayOf(ShowNewExportModule::class)
)
interface ShowNewExportComponent : ShowNewFilmsProvider {
    class Initializer private constructor() {
        companion object {
            fun init(mainToolsProvider: MainToolsProvider): ShowNewFilmsProvider =
                DaggerShowNewExportComponent.builder()
                    .mainToolsProvider(mainToolsProvider)
                    .build()
        }
    }

}