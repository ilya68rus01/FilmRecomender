package khrushchev.ilya.automizer.helper

sealed class ConfigurationName(val name: String)
object Impl : ConfigurationName("implementation")
object TestImpl : ConfigurationName("testImplementation")
object Kapt : ConfigurationName("kapt")
object AndroidTestImpl : ConfigurationName("androidTestImplementation")
object CompileOnly : ConfigurationName("compileOnly")
object RuntimeOnly : ConfigurationName("runtimeOnly")
object DebugImpl : ConfigurationName("debugImplementation")