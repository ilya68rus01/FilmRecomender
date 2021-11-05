plugins {
    id ("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    viewBinding {
        android.buildFeatures.viewBinding = true
    }

    defaultConfig {
        applicationId = "khrushchev.ilya.filmrecomender"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(AppDependencies.appLibraries)
    implementation(project(mapOf("path" to ":moduleinjector")))
    testImplementation(AppDependencies.testLibraries)
    kapt(AppDependencies.kapt)
    implementation(project(mapOf("path" to ":core")))
    implementation(project(mapOf("path" to ":shownew")))
}