package khrushchev.ilya.automizer

import com.android.build.api.dsl.ApkSigningConfig
import khrushchev.ilya.automizer.managers.SigningPropertiesManager

fun ApkSigningConfig.setUp(signingPropertiesManager: SigningPropertiesManager) {
    storeFile = signingPropertiesManager.storeFile
    storePassword = signingPropertiesManager.storePassword
    keyAlias = signingPropertiesManager.keyAlias
    keyPassword = signingPropertiesManager.keyPassword
}