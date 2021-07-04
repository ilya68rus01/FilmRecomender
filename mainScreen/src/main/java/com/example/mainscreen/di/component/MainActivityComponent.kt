package com.example.mainscreen.di.component

import com.example.core.di.ApplicationProvider
import com.example.mainscreen.MainActivity
import com.example.mainscreen.di.module.MainActivityModule
import dagger.Component

@Component(
    dependencies = arrayOf(ApplicationProvider::class),
    modules = arrayOf(MainActivityModule::class)
)
interface MainActivityComponent {
    fun inject(activity: MainActivity)

    class Initializer private constructor() {
        companion object {
            fun init(applicationProvider: ApplicationProvider): MainActivityComponent =
                DaggerMainActivityComponent.builder()
                    .applicationProvider(applicationProvider)
                    .build()
        }
    }
}