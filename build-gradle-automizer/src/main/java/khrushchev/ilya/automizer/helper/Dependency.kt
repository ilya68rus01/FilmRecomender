package khrushchev.ilya.automizer.helper

import org.gradle.api.Project

sealed class Dependency(
    val dependencies: Sequence<AppDependency> = emptySequence()
)

object EmptyDependency : Dependency()

data class ProjectDependency(
    val targets: Sequence<ProjectSpec> = emptySequence()
) : Dependency(targets)

class NamedDependency(
    private val names: Sequence<NameSpec> = emptySequence()
) : Dependency(names)

data class MixedDependency(
    val names: Sequence<NameSpec> = emptySequence(),
    val targets: Sequence<ProjectSpec> = emptySequence(),
) : Dependency(targets + names)

fun addDep(vararg projectSpec: ProjectSpec): ProjectDependency =
    ProjectDependency(projectSpec.asSequence())

fun addDep(vararg dependencies: NameSpec): NamedDependency =
    dependencies.asSequence().let(::NamedDependency)

val Sequence<AppDependency>.names: Sequence<NameSpec>
    get() = filterIsInstance(NameSpec::class.java)

val Sequence<AppDependency>.targets: Sequence<ProjectSpec>
    get() = filterIsInstance(ProjectSpec::class.java)

fun Project.module(name: String): ProjectSpec = ProjectSpec(Target(project(":$name")), Impl)

infix operator fun Dependency.plus(dep: Dependency): MixedDependency = MixedDependency(
    dependencies.names + dep.dependencies.names,
    dependencies.targets + dep.dependencies.targets,
)

infix operator fun Dependency.plus(dep: NamedDependency): NamedDependency = NamedDependency(
    dependencies.names + dep.dependencies.names
)

val String.impl: NameSpec
    get() = NameSpec(this, Impl)
val String.test: NameSpec
    get() = NameSpec(this, TestImpl)
val String.androidTest: NameSpec
    get() = NameSpec(this, AndroidTestImpl)
val String.kapt: NameSpec
    get() = NameSpec(this, Kapt)
val String.compile: NameSpec
    get() = NameSpec(this, CompileOnly)
val String.runtime: NameSpec
    get() = NameSpec(this, RuntimeOnly)
val String.debugImpl: NameSpec
    get() = NameSpec(this, DebugImpl)