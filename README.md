## Project structure

The project consists of a single `lib` library, but we imagine that we want to share some dependencies between the main library and build logic.
In this case, the "common" dependencies are actually test dependencies.

The project consists of:

- the root project, declaring `settings.gradle.kts`
- the `build-logic` included build (similar to `buildSrc`, really)
- the `lib` project for the actual library code

And then we imagine a `shared-catalog` project, corresponding to a _published_ (text based) catalog.

## How versions are shared

The first thing to look at is the _independent_ `shared-catalog` project.
It uses the `version-catalog` plugin to actually declare a catalog which can be published ion a remote repository.
You need to publish the catalog first:

    cd shared-catalog
    gradle publish

The generated catalog can be browsed at `build/repo/org/gradle/poc/shared-catalog`.
You will see it contains a generated TOML file.

Then the rest is pretty straightforward: both the "main" build and the "build logic" want to use the same, externally published catalog.
All they have to do is to consume it from their respective `settings.gradle.kts` files:

```kotlin
dependencyResolutionManagement {
    repositories {
        jcenter()
        maven {
            url = uri("../shared-catalog/build/repo")
        }
    }
    versionCatalogs {
        create("libs") {
            // this is a regular dependency notation, but
            // we look for a catalog!
            from("org.gradle.poc:shared-catalog:1.0")
        }
    }
}
```