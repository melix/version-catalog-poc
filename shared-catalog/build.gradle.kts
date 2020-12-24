plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        create("sharedCatalog") {
            id = "org.gradle.my-catalog"
            implementationClass = "org.gradle.MyCatalogPlugin"
        }
    }
}
