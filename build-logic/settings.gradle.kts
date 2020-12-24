dependencyResolutionManagement {
    repositories {
        jcenter()
    }
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

