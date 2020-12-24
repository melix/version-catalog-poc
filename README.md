## Project structure

The project consists of a single `lib` library, but we imagine that we want to share some dependencies between the main library and build logic.
In this case, the "common" dependencies are actually test dependencies.

The project consists of:

- the root project, declaring `settings.gradle.kts`
- the `build-logic` included build (similar to `buildSrc`, really)
- the `lib` project for the actual library code

## What to do

We basically want to share a catalog between build logic and the main build.
This is a simplified version of what you would have to do to share a catalog between different components in an organization.

In this repository, you will need to take a look at 4 different branches to explore the options we have:

- the `with-settings-plugin` demonstrates sharing versions via a Settings plugin
- the `with-precompiled-settings-plugin` does the same using a precompiled settings plugin
- the `with-toml` version shows how to do the same using the conventional TOML file
- the `with-published-catalog` demonstrates a similar thing but this time with a "published TOML" file

