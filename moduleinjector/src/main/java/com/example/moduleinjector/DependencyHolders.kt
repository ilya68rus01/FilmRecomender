package com.example.moduleinjector

abstract class DependencyHolder0<Dependencies : BaseFeatureDependencies>(
) : BaseDependencyHolder<Dependencies> {

    companion object {
        operator fun <D : BaseFeatureDependencies> invoke(block: (BaseDependencyHolder<D>) -> D): BaseDependencyHolder<D> {
            return object : DependencyHolder0<D>() {
                override val block = block
            }
        }
    }

    abstract val block: (BaseDependencyHolder<Dependencies>) -> Dependencies

    override val dependencies: Dependencies
        get() = block(this)
}

abstract class DependencyHolder1<Api1 : BaseFeatureApi, Dependencies : BaseFeatureDependencies>(
    private val api1: Api1,
) : BaseDependencyHolder<Dependencies> {

    companion object {
        operator fun <Api1 : BaseFeatureApi, Dependencies : BaseFeatureDependencies> invoke(
            api1: Api1,
            block: (BaseDependencyHolder<Dependencies>, Api1) -> Dependencies
        ): BaseDependencyHolder<Dependencies> {
            return object : DependencyHolder1<Api1, Dependencies>(
                api1 = api1
            ) {
                override val block = block
            }
        }
    }

    abstract val block: (BaseDependencyHolder<Dependencies>, Api1) -> Dependencies

    override val dependencies: Dependencies
        get() = block(this, api1)
}
