package khrushchev.ilya.automizer

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.plugins.AppPlugin
import com.android.build.gradle.internal.plugins.LibraryPlugin
import khrushchev.ilya.automizer.dependencies.Dependencies
import khrushchev.ilya.automizer.helper.addDep
import khrushchev.ilya.automizer.managers.DebugSigningPropertiesManager
import khrushchev.ilya.automizer.managers.ReleaseSigningPropertiesManager
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AppModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.all {
                addCommonPlugins()
                when (this) {
                    is AppPlugin -> {
//                        Тут можно запустить экстеншен который будет добавлять таск по логике инкрементации билда
//                        autoInc()
                        applicationOptions()
                        appApp()
                    }
                    is LibraryPlugin -> {
                        libraryOptions()
                    }
                }
            }
        }
    }
}


/** Default option for all project */
private fun Project.addCommonPlugins() {
    plugins.apply("kotlin-android")
    plugins.apply("kotlin-kapt")

    configure<BaseExtension> {
        defaultConfig {
            multiDexEnabled = true
        }
    }

    applyDependency(
        addDep(
            *Dependencies.baseDependency
        )
    )
}

private fun Project.appApp() {
    plugins.apply("kotlin-kapt")
    plugins.apply("org.jetbrains.kotlin.android")
}

fun Project.getSigningProperties(signingName: String) = when (signingName) {
    debug -> DebugSigningPropertiesManager(projectDir.path)
    release -> ReleaseSigningPropertiesManager(projectDir.path)
    else -> throw IllegalStateException("Unknown signingName $signingName")
}