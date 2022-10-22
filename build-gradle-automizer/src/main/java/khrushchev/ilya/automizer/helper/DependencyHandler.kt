package khrushchev.ilya.automizer.helper

import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addDependencyTo(
    configurationName: String,
    dependencyNotation: String,
    configuration: ExternalModuleDependency.() -> Unit = {}
): ExternalModuleDependency = org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo(
    this,
    configurationName,
    dependencyNotation,
    configuration
)

fun DependencyHandler.addModuleTo(
    configurationName: String,
    module: Project,
    projectDependency: ProjectDependency.() -> Unit = {}
): ProjectDependency = org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo(
    this,
    configurationName,
    module,
    projectDependency
)