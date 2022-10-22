package khrushchev.ilya.automizer

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import khrushchev.ilya.automizer.helper.*
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

fun Project.application(
    appDependency: Dependency = EmptyDependency,
    plugins: Plugin = EmptyPlugins,
    baseAppModuleExtension: (BaseAppModuleExtension.() -> Unit) = {}
) {
    addPlugins(applicationPlugin + plugins)
    applyDependency(appDependency)
    configure<BaseAppModuleExtension> {
        baseAppModuleExtension()
    }
}

internal fun Project.addPlugins(plugin: Plugin) {
    plugin.plugins.forEach {
        plugins.apply(it)
    }
}

fun Project.applyDependency(
    appDependency: Dependency = EmptyDependency
) {
    dependencies {
        appDependency.dependencies.forEach { dep ->
            when (dep) {
                is ProjectSpec -> {
                    addModuleTo(
                        dep.configurationName.name,
                        dep.target.project,
                    )
                }
                is NameSpec -> {
                    addDependencyTo(
                        dep.configurationName.name,
                        dep.name,
                    )
                }
            }
        }
    }
}