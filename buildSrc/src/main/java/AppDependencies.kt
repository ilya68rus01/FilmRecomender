import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //std lib
    val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //android ui
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    //test libs
    val junit = "junit:junit:${Versions.junit}"
    val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    private val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    private val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    private val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"

    private val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    private val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    val appLibraries = listOf(
        coreKtx,
        appcompat,
        dagger,
        daggerAndroid,
        daggerSupport
    )

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }

    val kapt = listOf(
        daggerCompiler,
        daggerProcessor
    )
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}