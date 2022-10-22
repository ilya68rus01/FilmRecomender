package khrushchev.ilya.automizer

import khrushchev.ilya.automizer.helper.ApplicationPlugin
import khrushchev.ilya.automizer.helper.LibraryPlugin
import khrushchev.ilya.automizer.helper.addAppPlug
import khrushchev.ilya.automizer.helper.addLibPlug

/** Default Plugin for library dependency */
val libraryPlugin: LibraryPlugin = addLibPlug(
    "com.android.library",
    "app-plugin",
)

/** Default Plugin for application dependency */
val applicationPlugin: ApplicationPlugin = addAppPlug(
    "com.android.application",
    "app-plugin",
)