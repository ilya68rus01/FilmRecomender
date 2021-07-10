object NetworkDependencies {
    private val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    private val kotlinCore = "androidx.core:core-ktx:${Versions.kotlin}"
    private val material = "com.google.android.material:material:${Versions.material}"

    private val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    private val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    private val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    //Retrofit
    private val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    private val gson = "com.google.code.gson:gson:${Versions.gson}"

    private val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin}"
    private val rxJava = "io.reactivex.rxjava3:rxjava:3.0.0"

    private val converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private val adapter = "com.squareup.retrofit2:adapter-rxjava3:2.9.0"

    private val junit = "junit:junit:4.+"

    private val androidJunit = "androidx.test.ext:junit:1.1.2"
    private val espresso = "androidx.test.espresso:espresso-core:3.3.0"

    val networkLibraries = listOf(
        stdLib,
        retrofit,
        gson,
        coroutines,
        rxJava,
        converter,
        adapter,
        kotlinCore,
        material,
        dagger
    )

    val androidTestLibraries = listOf(
        androidJunit,
        espresso
    )

    val testLibraries = listOf(
        junit
    )

    val kaptLibraries = listOf(
        daggerCompiler,
        daggerProcessor
    )
}