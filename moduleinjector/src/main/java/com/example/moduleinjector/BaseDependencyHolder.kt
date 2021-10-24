package com.example.moduleinjector

interface BaseDependencyHolder<Dependency : BaseFeatureDependencies> {
    val dependencies: Dependency
}