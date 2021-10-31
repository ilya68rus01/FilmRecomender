object InjectorDependencies {

    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val injectorLibs = listOf(
        appcompat,
        coreKtx,
    )

    val androidTestLibraries = listOf(
        extJUnit,
        espressoCore
    )

    val testLibraries = listOf(
        junit
    )
}