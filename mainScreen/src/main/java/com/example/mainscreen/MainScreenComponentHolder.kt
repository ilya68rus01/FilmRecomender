package com.example.mainscreen

import com.example.mainscreen.di.component.DaggerMainScreenComponent
import com.example.mainscreen.di.component.MainScreenComponent
import com.example.moduleinjector.BaseFeatureApi
import com.example.moduleinjector.ComponentHolder
import com.example.moduleinjector.ComponentHolderDelegate

interface MainScreenApi : BaseFeatureApi {

}

object MainScreenComponentHolder : ComponentHolder<MainScreenApi, MainScreenDependencies> {

    private val componentHolderDelegate =
        ComponentHolderDelegate<MainScreenApi, MainScreenDependencies, MainScreenComponent> {
            DaggerMainScreenComponent
                .factory()
                .create(it)
        }

    override var dependenciesProvider by componentHolderDelegate::dependenciesProvider

    override fun get(): MainScreenApi = componentHolderDelegate.get()

    internal fun getComponent(): MainScreenComponent =
        componentHolderDelegate.getComponentImpl()
}