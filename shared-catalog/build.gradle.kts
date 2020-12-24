plugins {
    `version-catalog`
    `maven-publish`
}

group = "org.gradle.poc"
version = "1.0"

catalog {
    versionCatalog {
        alias("junit-api").to("org.junit.jupiter:junit-jupiter-api:5.7.0")
        alias("junit-engine").to("org.junit.jupiter", "junit-jupiter-engine").withoutVersion()

        alias("commons-math3").to("org.apache.commons:commons-math3:3.6.1")

        alias("guava").to("com.google.guava:guava:30.0-jre")
    }
}

publishing {
    repositories {
        maven {
            name = "project"
            url = uri("${buildDir}/repo")
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}
