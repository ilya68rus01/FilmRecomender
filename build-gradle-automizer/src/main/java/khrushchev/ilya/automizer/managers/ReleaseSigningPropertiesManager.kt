package khrushchev.ilya.automizer.managers

import java.io.File

class ReleaseSigningPropertiesManager(
    private val parentPath: String
) : SigningPropertiesManager(parentPath) {
    override val storeFile: File
        get() = File(parentPath, getStringValue("SIGNING_STORE_FILE_PATH_RELEASE"))
    override val storePassword: String
        get() = getStringValue("SIGNING_STORE_PASSWORD_RELEASE")
    override val keyAlias: String
        get() = getStringValue("SIGNING_KEY_ALIAS_RELEASE")
    override val keyPassword: String
        get() = getStringValue("SIGNING_KEY_PASSWORD_RELEASE")
}