## Project structure

The project consists of a single `lib` library, but we imagine that we want to share some dependencies between the main library and build logic.
In this case, the "common" dependencies are actually test dependencies.

The project consists of:

- the root project, declaring `settings.gradle.kts`
- the `build-logic` included build (similar to `buildSrc`, really)
- the `lib` project for the actual library code

## How versions are shared

This POC declares a `gradle/dependencies.toml` file with the version catalog.
This file is used by convention by the main build, so we only need to explain to the `build-logic` project how to use it.

It's done in `build-logic/settings.gradle.kts`:

    versionCatalogs {
        create("libs") {
            from(files("../gradle/dependencies.toml"))
        }
    }

That's it!
