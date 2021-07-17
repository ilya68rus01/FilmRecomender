object CoreDependencies {
    private val kotlinCore = "androidx.core:core-ktx:${Versions.kotlin}"

    private val coreKtx = "androidx.core:core-ktx:1.5.0"
    private val appCompat = "androidx.appcompat:appcompat:1.3.0"
    private val material = "com.google.android.material:material:1.3.0"
    private val rxAndroid = "io.reactivex.rxjava3:rxandroid:3.0.0"
    private val rx = "io.reactivex.rxjava3:rxjava:3.0.0"

    private val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    private val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    private val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    private val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    private val daggerAndroidSup = "com.google.dagger:dagger-android-support:${Versions.dagger}"

    private val junit = "junit:junit:4.+"

    private val androidJunit = "androidx.test.ext:junit:1.1.2"
    private val espresso = "androidx.test.espresso:espresso-core:3.3.0"

    val coreLibraries = listOf(
        coreKtx,
        appCompat,
        material,
        rxAndroid,
        rx,
        kotlinCore,
        dagger,
        daggerAndroid,
        daggerAndroidSup
    )

    val coreKapt = listOf(
        daggerCompiler,
        daggerProcessor
    )

    val androidTestLibraries = listOf(
        androidJunit,
        espresso
    )

    val testLibraries = listOf(
        junit
    )
}