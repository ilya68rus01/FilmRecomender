import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //std lib
    val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //android ui
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    val cardView = "androidx.cardview:cardview:1.0.0"
    val material = "com.google.android.material:material:1.3.0"


    //Navigation component
    // Kotlin
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Feature module Support
    val navigationFeatures =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"

    // Jetpack Compose Integration
    val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-alpha01"

    //Paging Library
    val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    //RxJava3 support
    val pagingRx = "androidx.paging:paging-rxjava3:${Versions.paging}"

    //Jetpack Compose integration
    val pagingCompose = "androidx.paging:paging-compose:1.0.0-alpha09"

    //RxJava 3
    val rxAndroid = "io.reactivex.rxjava3:rxandroid:3.0.0"
    val rxJava = "io.reactivex.rxjava3:rxjava:3.0.0"

    //Room
    val room = "androidx.room:room-runtime:${Versions.room}"
    val roomAnnotation = "androidx.room:room-compiler:${Versions.room}"

    // optional - RxJava3 support for Room
    val roomRx = "androidx.room:room-rxjava3:${Versions.room}"


    // Kotlin
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"


    //test libs
    val junit = "junit:junit:${Versions.junit}"
    val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // Testing Fragments in Isolation
    val fragmetnTesting = "androidx.fragment:fragment-testing:${Versions.fragment}"

    // Testing Navigation
    val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navigation}"

    val annotation = arrayListOf<String>().apply {
        add(roomAnnotation)
    }

    val appLibraries = arrayListOf<String>().apply {
        add(stdLib)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(cardView)
        add(material)
        add(navigationFragment)
        add(navigationUiKtx)
        add(navigationFeatures)
        add(navigationCompose)
        add(paging)
        add(pagingRx)
        add(pagingCompose)
        add(rxAndroid)
        add(rxJava)
        add(room)
        add(roomRx)
        add(fragmentKtx)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
        add(navigationTesting)
        add(fragmetnTesting)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
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