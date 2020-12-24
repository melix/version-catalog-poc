package org.gradle

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

open class MyCatalogPlugin : Plugin<Settings> {
    override fun apply(settings: Settings) = settings.run {
        dependencyResolutionManagement {
            versionCatalogs {
                create("libs") {
                    alias("junit-api").to("org.junit.jupiter:junit-jupiter-api:5.7.0")
                    alias("junit-engine").to("org.junit.jupiter", "junit-jupiter-engine").withoutVersion()

                    alias("commons-math3").to("org.apache.commons:commons-math3:3.6.1")

                    alias("guava").to("com.google.guava:guava:30.0-jre")
                }
            }
        }
    }
}