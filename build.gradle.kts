plugins {
    kotlin("jvm") version "2.1.0"

    id("com.github.ben-manes.versions") version "0.51.0"

    idea
}

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

dependencies {
    // Tests
    testImplementation(tests.bundles.kotest)
}

tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
    fun isStable(version: String): Boolean {
        val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { it in version.uppercase() }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        return stableKeyword || regex.matches(version)
    }

    rejectVersionIf {
        isStable(currentVersion) && !isStable(candidate.version)
    }
}

tasks
    .withType<Test>()
    .configureEach {
        useJUnitPlatform()
        jvmArgs("-XX:+EnableDynamicAgentLoading")
    }
