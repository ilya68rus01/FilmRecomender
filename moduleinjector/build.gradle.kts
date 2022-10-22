import khrushchev.ilya.automizer.helper.addDep
import khrushchev.ilya.automizer.helper.androidTest
import khrushchev.ilya.automizer.helper.impl
import khrushchev.ilya.automizer.helper.test
import khrushchev.ilya.automizer.module

module(
    appDependency = addDep(
        *InjectorDependencies.injectorLibs.map {
            it.impl
        }.toTypedArray(),
        *InjectorDependencies.testLibraries.map {
            it.test
        }.toTypedArray(),
        *InjectorDependencies.androidTestLibraries.map {
            it.androidTest
        }.toTypedArray()
    )
)