object CoreDependencies {
    private val kotlinCore = "androidx.core:core-ktx:${Versions.kotlin}"
    private val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val material = "com.google.android.material:material:${Versions.material}"
    private val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rx}"
    private val rx = "io.reactivex.rxjava3:rxjava:${Versions.rx}"

    private val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    private val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    private val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    private val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    private val daggerAndroidSup = "com.google.dagger:dagger-android-support:${Versions.dagger}"

    private val junit = "junit:junit:${Versions.junit}"

    private val androidJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private val gson = "com.google.code.gson:gson:${Versions.gsonVersions}"

    val coreLibraries = listOf(
        appCompat,
        material,
        rxAndroid,
        rx,
        kotlinCore,
        dagger,
        daggerAndroid,
        daggerAndroidSup,
        gson
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