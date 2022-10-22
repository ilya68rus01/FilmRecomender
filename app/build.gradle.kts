import khrushchev.ilya.automizer.application
import khrushchev.ilya.automizer.helper.*

application(
    appDependency = addDep(
        *AppDependencies.appLibraries.map {
            it.impl
        }.toTypedArray(),
        *AppDependencies.testLibraries.map {
            it.test
        }.toTypedArray(),
        *AppDependencies.kapt.map {
            it.kapt
        }.toTypedArray(),
    ) + addDep(
        module("moduleinjector"),
        module("film_info"),
        module("core"),
        module("shownew")
    ),
    baseAppModuleExtension = {
        buildFeatures {
            viewBinding = true
        }
    }
)