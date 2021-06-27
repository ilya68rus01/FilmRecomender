import org.gradle.api.artifacts.dsl.DependencyHandler

object ShowNewDependencies {
    //std lib
    val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //android ui
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    val cardView = "androidx.cardview:cardview:1.0.0"
    val material = "com.google.android.material:material:1.3.0"

    val showNewLibraries = listOf(
        stdLib,
        appcompat,
        coreKtx,
        constraintLayout,
        cardView,
        material
    )
}