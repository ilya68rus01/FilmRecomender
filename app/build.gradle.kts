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
}

dependencies {
    implementation(AppDependencies.appLibraries)
    implementation(project(mapOf("path" to ":mainScreen")))
    implementation(project(mapOf("path" to ":moduleinjector")))
    testImplementation(AppDependencies.testLibraries)
    annotationProcessor(AppDependencies.roomAnnotation)
    kapt(AppDependencies.kapt)
    implementation(project(mapOf("path" to ":core")))
    implementation(project(mapOf("path" to ":shownew")))
}