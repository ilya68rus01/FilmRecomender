plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
}


android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            buildConfigField("String","TMDB_API_KEY", getLocalProperty("TMDB_API_KEY").toString())
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isMinifyEnabled = false
            buildConfigField("String","TMDB_API_KEY", getLocalProperty("TMDB_API_KEY").toString())
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(ShowNewDependencies.showNewLibraries)
    implementation(project(mapOf("path" to ":moduleinjector")))
    kapt(ShowNewDependencies.kaptLibraries)
    implementation(project(mapOf("path" to ":core")))
}