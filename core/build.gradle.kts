import khrushchev.ilya.automizer.helper.*
import khrushchev.ilya.automizer.module

module(
    appDependency = addDep(
        *CoreDependencies.coreLibraries.map {
            it.impl
        }.toTypedArray(),
        *CoreDependencies.coreKapt.map {
            it.kapt
        }.toTypedArray(),
        *CoreDependencies.testLibraries.map {
            it.test
        }.toTypedArray(),
        *CoreDependencies.androidTestLibraries.map {
            it.androidTest
        }.toTypedArray(),
    ),
    androidLibraryConfiguration = {
        buildFeatures {
            viewBinding = true
        }
    }
)