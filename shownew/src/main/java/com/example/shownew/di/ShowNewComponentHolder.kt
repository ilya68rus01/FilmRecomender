package com.example.shownew.di

import com.example.moduleinjector.BaseFeatureApi
import com.example.moduleinjector.ComponentHolder
import com.example.moduleinjector.ComponentHolderDelegate
import com.example.shownew.di.component.DaggerShowNewComponent
import com.example.shownew.di.component.ShowNewComponent

interface ShowNewApi : BaseFeatureApi {

}

object ShowNewComponentHolder : ComponentHolder<ShowNewApi, ShowNewDependencies> {

    private val componentHolderDelegate =
        ComponentHolderDelegate<ShowNewApi, ShowNewDependencies, ShowNewComponent> {
            DaggerShowNewComponent
                .factory()
                .create(it)
        }

    override var dependenciesProvider by componentHolderDelegate::dependenciesProvider

    override fun get(): ShowNewApi = componentHolderDelegate.get()

    internal fun getComponent(): ShowNewComponent = componentHolderDelegate.getComponentImpl()
}