package khrushchev.ilya.automizer.dependencies

import khrushchev.ilya.automizer.helper.androidTest
import khrushchev.ilya.automizer.helper.impl
import khrushchev.ilya.automizer.helper.test

object Dependencies {
    //std lib
    private val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}".impl

    //android ui
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}".impl
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}".impl
    private val material = "com.google.android.material:material:${Versions.material}".impl

    //test libs
    private val junit = "junit:junit:${Versions.junit}".test
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}".androidTest
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}".androidTest

    val baseDependency = arrayOf(
        stdLib,
        appcompat,
        coreKtx,
        material,
        junit,
        extJUnit,
        espressoCore,
    )
}