package com.example.moduleinjector

import java.lang.ref.WeakReference

class ComponentHolderDelegate<
        Api : BaseFeatureApi,
        Dependencies : BaseFeatureDependencies,
        Component : Api
        >(
    private val componentFactory: (Dependencies) -> Component
) : ComponentHolder<Api, Dependencies> {

    override var dependenciesProvider: (() -> Dependencies)? = null

    private var componentWeakReference: WeakReference<Component>? = null

    fun getComponentImpl(): Component {
        var component: Component? = null
        synchronized(this) {
            dependenciesProvider?.let { dependenciesProvider ->
                component = componentWeakReference?.get()
                if (component == null) {
                    component = componentFactory(dependenciesProvider())
                    componentWeakReference = WeakReference(component)
                }
            }
                ?: throw IllegalStateException("dependencyProvider for component with factory $componentFactory is not initialized")
        }
        return component
            ?: throw IllegalStateException("ComponentHolder with component factory $componentFactory is not initialized")
    }

    override fun get(): Api = getComponentImpl()
}
