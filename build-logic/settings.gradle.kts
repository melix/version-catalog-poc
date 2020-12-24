pluginManagement {
    includeBuild("../shared-catalog")
    repositories {
        gradlePluginPortal()
        jcenter()
    }
}

plugins {
    id("org.gradle.my-catalog")
}

dependencyResolutionManagement {
    repositories {
        jcenter()
    }
}

