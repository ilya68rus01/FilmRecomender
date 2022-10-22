//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//        maven { setUrl("https://maven.google.com") }
//        gradlePluginPortal()
//    }
//}

includeBuild("$rootDir/build-gradle-automizer")
include(":app", ":shownew", ":core", ":moduleinjector", ":film_info")
rootProject.name = "FilmRecomender"
