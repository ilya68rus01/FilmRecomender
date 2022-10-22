package khrushchev.ilya.automizer

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import khrushchev.ilya.automizer.helper.*
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.module(
    appDependency: Dependency = EmptyDependency,
    plugins: Plugin = EmptyPlugins,
    androidLibraryConfiguration: (LibraryExtension.() -> Unit) = {}
) {
    addPlugins(libraryPlugin + plugins)
    applyDependency(appDependency)
    baseConfig()

    configure<LibraryExtension> {
        androidLibraryConfiguration()
    }
}

fun Project.baseConfig() {
    configure<BaseExtension> {
        defaultConfig {
            buildConfigField("String","TMDB_API_KEY", getLocalProperty("TMDB_API_KEY").toString())
        }
    }
}