plugins {
    `kotlin-dsl`
}

dependencies {
    // Use JUnit Jupiter API for testing.
    testImplementation(libs.junit.api)

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly(libs.junit.engine)
}