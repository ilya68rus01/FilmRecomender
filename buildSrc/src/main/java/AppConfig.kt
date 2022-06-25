import org.gradle.api.Project
import java.io.File

//app level config constants
object AppConfig {
    const val compileSdk = 31
    const val minSdk = 25
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val buildToolsVersion = "30.0.2"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val proguardConsumerRules =  "consumer-rules.pro"
    const val dimension = "environment"
}

fun Project.getLocalProperty(key: String, file: String = "local.properties"): Any {
    val properties = java.util.Properties()
    val localProperties = File(file)
    if (localProperties.isFile) {
        java.io.InputStreamReader(java.io.FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
            properties.load(reader)
        }
    } else error("File from not found")

    return properties.getProperty(key)
}