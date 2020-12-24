dependencyResolutionManagement {
    repositories {
        jcenter()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/dependencies.toml"))
        }
    }
}
