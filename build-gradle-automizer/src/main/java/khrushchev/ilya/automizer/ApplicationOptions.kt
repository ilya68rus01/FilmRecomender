package khrushchev.ilya.automizer

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import java.io.File

internal fun Project.applicationOptions() = extensions.getByType<BaseAppModuleExtension>().run {

    repositories {
        google()
        mavenCentral()
    }

    signingConfigs {
        create(release) {
            setUp(getSigningProperties(this.name))
        }

        getByName(debug) {
            setUp(getSigningProperties(this.name))
        }
    }

    defaultConfig {
        applicationId = "khrushchev.ilya.filmrecomender"
        minSdk = 21
        targetSdk = 32
        compileSdk = 32
        versionCode = 1
        versionName = "1-SNAPSHOT"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        findByName(release)?.apply {
            signingConfig = signingConfigs.getByName(this.name)
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        findByName(debug)?.apply {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<KotlinCompile<KotlinJvmOptions>> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

internal fun Project.libraryOptions() = extensions.getByType<LibraryExtension>().run {
    repositories {
        google()
        mavenCentral()
    }

    defaultConfig {
        minSdk = 21
        targetSdk = 32
        compileSdk = 32
        consumerProguardFiles("proguard-rules.pro")
    }

    buildTypes {
        findByName(release)?.apply {
            isMinifyEnabled = false
            buildConfigField("String","TMDB_API_KEY", getLocalProperty("TMDB_API_KEY").toString())
        }

        findByName(debug)?.apply {
            buildConfigField("String","TMDB_API_KEY", getLocalProperty("TMDB_API_KEY").toString())
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<KotlinCompile<KotlinJvmOptions>> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

fun Project.getLocalProperty(key: String, file: String = "local.properties"): Any {
    val properties = java.util.Properties()
    val localProperties = File(file)
    if (localProperties.isFile) {
        java.io.InputStreamReader(java.io.FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
            properties.load(reader)
        }
    } else error("File from not found")

    return properties.getProperty(key)
}