object MainScreenDependencies {

    private val material = "com.google.android.material:material:1.3.0"
    private val constraint = "androidx.constraintlayout:constraintlayout:2.0.4"
    private val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //std lib
    private val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //android ui
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    // Feature module Support
    private val navigationFeatures =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"

    //RxJava 3
    private val rxAndroid = "io.reactivex.rxjava3:rxandroid:3.0.0"
    private val rxJava = "io.reactivex.rxjava3:rxjava:3.0.0"

    //Room
    private val room = "androidx.room:room-runtime:${Versions.room}"
    private val roomAnnotation = "androidx.room:room-compiler:${Versions.room}"

    // optional - RxJava3 support for Room
    private val roomRx = "androidx.room:room-rxjava3:${Versions.room}"


    // Kotlin
    private val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"


    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // Testing Fragments in Isolation
    private val fragmetnTesting = "androidx.fragment:fragment-testing:${Versions.fragment}"

    // Testing Navigation
    private val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navigation}"

    val mainScreenLibraries = listOf(
        material,
        constraint,
        navigationFragment,
        navigationUi,
        stdLib,
        appcompat,
        coreKtx,
        navigationFeatures,
        rxAndroid,
        rxJava,
        room,
        roomAnnotation,
        roomRx,
        fragmentKtx
    )

    val androidTestLibraries = listOf(
        junit,
        extJUnit,
        espressoCore
    )

    val testLibraries = listOf(
        junit
    )
}