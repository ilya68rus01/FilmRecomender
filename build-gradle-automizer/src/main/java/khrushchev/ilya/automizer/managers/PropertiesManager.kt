package khrushchev.ilya.automizer.managers

import java.util.*

abstract class PropertiesManager {
    abstract val properties: Properties

    fun getStringValue(name: String): String =
        properties.getProperty(name) ?: System.getenv(name).orEmpty() // ?: throw IllegalStateException("Property $name is missing")
}