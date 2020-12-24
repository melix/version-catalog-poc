## Project structure

The project consists of a single `lib` library, but we imagine that we want to share some dependencies between the main library and build logic.
In this case, the "common" dependencies are actually test dependencies.

The project consists of:

- the root project, declaring `settings.gradle.kts`
- the `build-logic` included build (similar to `buildSrc`, really)
- the `lib` project for the actual library code

and a special `shared-catalog` included build which is actually a settings plugin.

## How versions are shared

This POC declares a `shared-catalog` settings plugin.
The plugin uses the traditional plugin API to do this:

```kotlin
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
```

This plugin is responsible for calling the `Settings` API to declare the catalog.
The catalog must then be used by:

- the "main" build
- the "build-logic" build

which needs to be done using the new included build API in plugin management:

```kotlin
pluginManagement {
    includeBuild("shared-catalog")
    repositories {
        gradlePluginPortal()
        jcenter()
    }
}

plugins {
    // actually applies the catalog plugin
    id("org.gradle.my-catalog")
}
```

(this is done both in the main and build-logic builds)

And then it works properly.