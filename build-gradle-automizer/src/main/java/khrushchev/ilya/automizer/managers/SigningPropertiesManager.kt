package khrushchev.ilya.automizer.managers

import java.io.File
import java.util.*

private const val KEYSTORE_CONFIG_PATH = "keystore/keystore_config"

abstract class SigningPropertiesManager(parentPath: String) : PropertiesManager() {
    abstract val storeFile: File
    abstract val storePassword: String
    abstract val keyAlias: String
    abstract val keyPassword: String

    private val keyStoreConfigFile = File(parentPath, KEYSTORE_CONFIG_PATH)

    override val properties: Properties
        get() = Properties().apply {
            if (keyStoreConfigFile.exists()) {
                load(keyStoreConfigFile.reader())
            }
        }
}