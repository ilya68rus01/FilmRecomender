package khrushchev.ilya.automizer.helper

import org.gradle.api.Project

sealed class AppDependency(
    open val name: String,
    val configurationName: ConfigurationName,
)

data class ProjectSpec(
    val target: Target,
    val config: ConfigurationName,
) : AppDependency(target.name, config) {
    override fun toString(): String {
        return "Target = ${target.name} ConfigurationName = ${config.name}"
    }
}

data class NameSpec(
    override val name: String,
    val config: ConfigurationName,
) : AppDependency(name, config)

class Target(val project: Project) {
    val name: String = project.name
}