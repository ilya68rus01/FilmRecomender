package com.example.mainscreen.di.component

import com.example.mainscreen.MainActivity
import com.example.mainscreen.MainScreenApi
import com.example.mainscreen.MainScreenDependencies
import com.example.mainscreen.di.module.MainScreenModule
import dagger.Component


@Component(
    modules = [
        MainScreenModule::class
    ],
    dependencies = [
        MainScreenDependencies::class
    ]
)
interface MainScreenComponent : MainScreenApi, MainScreenDependencies {

    fun inject(mainScreenActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(dependencies: MainScreenDependencies): MainScreenComponent
    }
}