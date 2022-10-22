import khrushchev.ilya.automizer.helper.*
import khrushchev.ilya.automizer.module

module(
    appDependency = addDep(
        *FilmInfoDependencies.libraries.map {
            it.impl
        }.toTypedArray(),
        *FilmInfoDependencies.kaptLibraries.map {
            it.kapt
        }.toTypedArray()
    ) + addDep(
        module("moduleinjector"),
        module("core")
    ),
    androidLibraryConfiguration = {
        buildFeatures {
            viewBinding = true
        }
    }
)