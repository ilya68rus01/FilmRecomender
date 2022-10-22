plugins {
    `kotlin-dsl`
}

group = "khrushchev.ilya.automizer"
version = "SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

gradlePlugin {
    plugins {
        register("app-plugin") {
            id = "app-plugin"
            implementationClass = "khrushchev.ilya.automizer.AppModulePlugin"
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
    implementation(kotlin("gradle-plugin", "1.6.21"))
    implementation(kotlin("android-extensions"))
    implementation("com.android.tools.build:gradle:7.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}