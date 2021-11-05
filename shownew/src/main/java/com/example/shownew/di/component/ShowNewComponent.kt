package com.example.shownew.di.component

import com.example.shownew.di.ShowNewApi
import com.example.shownew.di.ShowNewDependencies
import com.example.shownew.di.module.ShowNewModule
import com.example.shownew.di.module.ViewModelModule
import com.example.shownew.ui.NewFilmsFragment
import dagger.Component

@Component(
    modules = [
        ShowNewModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        ShowNewDependencies::class
    ]
)
interface ShowNewComponent : ShowNewApi, ShowNewDependencies {

    fun inject(newFilmsFragment: NewFilmsFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: ShowNewDependencies): ShowNewComponent
    }
}