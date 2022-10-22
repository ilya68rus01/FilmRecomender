import khrushchev.ilya.automizer.helper.*
import khrushchev.ilya.automizer.module
module(
    appDependency = addDep(
        *ShowNewDependencies.showNewLibraries.map {
            it.impl
        }.toTypedArray(),
        *ShowNewDependencies.kaptLibraries.map {
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