package com.example.moduleinjector

interface ComponentHolder<Api : BaseFeatureApi, Dependencies : BaseFeatureDependencies> {
    var dependenciesProvider: (() -> Dependencies)?
    fun get(): Api
}