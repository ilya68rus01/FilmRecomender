dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
include(":app", ":shownew", ":core", ":moduleinjector")
rootProject.name = "FilmRecomender"
include(":mainScreen")
