/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/7.0-20201224092022+0000/userguide/multi_project_builds.html
 */

pluginManagement {
    includeBuild("shared-catalog")
    repositories {
        gradlePluginPortal()
        jcenter()
    }
}

plugins {
    id("org.gradle.my-catalog")
}

rootProject.name = "catalog-pocs"
include("lib")

includeBuild("build-logic")

dependencyResolutionManagement {
    repositories {
        jcenter()
    }
}
