plugins {
    id ("com.android.application")
    kotlin("android")
    kotlin("kapt")
}


android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    viewBinding {
        android.buildFeatures.viewBinding = true
    }

    defaultConfig {
        applicationId = "khrushchev.ilya.filmrecomender"
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isMinifyEnabled = false
        }
    }



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(ShowNewDependencies.showNewLibraries)
    // dagger
    kapt("com.google.dagger:dagger-compiler:${Versions.dagger}")
    implementation("com.google.dagger:dagger:${Versions.dagger}")
    kapt( "com.google.dagger:dagger-android-processor:${Versions.dagger}")
    implementation("com.google.dagger:dagger-android:${Versions.dagger}")
    implementation("com.google.dagger:dagger-android-support:${Versions.dagger}")


}