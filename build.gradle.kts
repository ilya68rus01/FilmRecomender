// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://maven.google.com") }
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("khrushchev.ilya.automizer:build-gradle-automizer:SNAPSHOT")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://maven.google.com") }
    }
}

subprojects {
    buildscript {
        repositories {
            google()
            mavenCentral()
            maven { setUrl("https://maven.google.com") }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

