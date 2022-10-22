package khrushchev.ilya.automizer.helper

typealias Plugins = Sequence<String>

sealed class Plugin(
    open val plugins: Plugins = emptySequence()
)

data class LibraryPlugin(
    override val plugins: Plugins
): Plugin(plugins)

data class ApplicationPlugin(
    override val plugins: Plugins
): Plugin(plugins)

data class MixPlugin(
    override val plugins: Plugins = emptySequence()
): Plugin(plugins)

object EmptyPlugins : Plugin(emptySequence())

fun addLibPlug(vararg string: String): LibraryPlugin = LibraryPlugin(string.asSequence())
fun addAppPlug(vararg string: String): ApplicationPlugin = ApplicationPlugin(string.asSequence())

infix operator fun Plugin.plus(plug: Plugin): Plugin = MixPlugin(
    this.plugins.plus(plug.plugins),
)
