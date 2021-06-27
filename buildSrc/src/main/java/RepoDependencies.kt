object RepoDependencies {
    val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //Retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    val gson = "com.google.code.gson:gson:${Versions.gson}"

    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin}"
    val rxJava = "io.reactivex.rxjava3:rxjava:3.0.0"

    val converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val adapter = "com.squareup.retrofit2:adapter-rxjava3:2.9.0"

    val repoImplements = listOf(
        stdLib,
        retrofit,
        gson,
        coroutines,
        rxJava,
        converter,
        adapter
    )
}