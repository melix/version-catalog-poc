## Project structure

The project consists of a single `lib` library, but we imagine that we want to share some dependencies between the main library and build logic.
In this case, the "common" dependencies are actually test dependencies.

The project consists of:

- the root project, declaring `settings.gradle.kts`
- the `build-logic` included build (similar to `buildSrc`, really)
- the `lib` project for the actual library code

## How versions are shared

This project doesn't try to share the versions between the main build and the `build-logic`:
it's there to show what it looks like if you only use the `settings.gradle.kts` file.

Basically both the `build-logic` and main build have to copy the catalog.
This example is there so that you can see what a simple build would look like without sharing and without a TOML file, so that we can compare the definitions.

