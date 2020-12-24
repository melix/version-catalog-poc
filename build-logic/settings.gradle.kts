dependencyResolutionManagement {
    repositories {
        jcenter()
        maven {
            url = uri("../shared-catalog/build/repo")
        }
    }
    versionCatalogs {
        create("libs") {
            from("org.gradle.poc:shared-catalog:1.0")
        }
    }
}
