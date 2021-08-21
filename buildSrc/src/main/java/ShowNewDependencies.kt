object ShowNewDependencies {
    //std lib
    private val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //android ui
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    private val cardView = "androidx.cardview:cardview:1.0.0"
    private val material = "com.google.android.material:material:1.3.0"

    private val lifeCycleKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"

    private val support = "androidx.legacy:legacy-support-v4:1.0.0"
    private val rxAndroid = "io.reactivex.rxjava3:rxandroid:3.0.0"
    private val rx = "io.reactivex.rxjava3:rxjava:3.0.0"
    private val fragments = "androidx.fragment:fragment-ktx:1.3.2"
    private val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    private val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    private val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"

    private val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    private val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    private val navigation = "androidx.navigation:navigation-fragment-ktx:2.3.5"
    private val navigationUi = "androidx.navigation:navigation-ui-ktx:2.3.5"


    private val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"


    val showNewLibraries = listOf(
        stdLib,
        appcompat,
        coreKtx,
        constraintLayout,
        cardView,
        material,
        lifeCycleKtx,
        support,
        rxAndroid,
        rx,
        fragments,
        dagger,
        daggerAndroid,
        daggerSupport,
        navigation,
        navigationUi,
        picasso
    )

    val kaptLibraries = listOf(
        daggerCompiler,
        daggerProcessor
    )
}