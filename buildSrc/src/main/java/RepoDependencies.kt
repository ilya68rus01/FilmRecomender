object RepoDependencies {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //Retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    val gson = "com.google.code.gson:gson:${Versions.gson}"

    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin}"
    val rxJava = "io.reactivex.rxjava3:rxjava:3.0.0"

    val converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val adapter = "com.squareup.retrofit2:adapter-rxjava3:2.9.0"

    private val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    private val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    private val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"

    private val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    private val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    private val junit = "junit:junit:4.+"

    private val junitAndroid = "androidx.test.ext:junit:1.1.2"
    private val espresso = "androidx.test.espresso:espresso-core:3.3.0"

    val repoImplements = listOf(
        appcompat,
        coreKtx,
        stdLib,
        retrofit,
        gson,
        coroutines,
        rxJava,
        converter,
        adapter,
        dagger,
        daggerAndroid,
        daggerSupport
    )

    val kapt = listOf(
        daggerCompiler,
        daggerProcessor
    )

    val testImplements = listOf(
        junit
    )

    val androidTest = listOf(
        junitAndroid,
        espresso
    )
}