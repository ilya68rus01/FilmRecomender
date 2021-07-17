package com.example.shownew.di.component

import com.example.core.di.ApplicationProvider
import com.example.shownew.NewFilmsFragment
import com.example.shownew.di.module.ViewModelModule
import dagger.Component

@Component(
    dependencies = [
        ApplicationProvider::class
    ],
    modules = [
        ViewModelModule::class
    ]
)
interface ShowNewComponent {
    fun inject(fragment: NewFilmsFragment)

    class Initializer private constructor() {
        companion object {
            fun init(
                applicationProvider: ApplicationProvider
            ): ShowNewComponent {
                return DaggerShowNewComponent.builder()
                    .applicationProvider(applicationProvider)
                    .build()
            }
        }
    }
}