rootProject.name = "aoc24"

buildCache {
    local {
        isEnabled = true
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("tests") {
            // Kotest
            version("kotest", "5.9.1")
            library(
                "kotest-runner-junit5",
                "io.kotest",
                "kotest-runner-junit5-jvm"
            ).versionRef("kotest")
            library(
                "kotest-framework-datatest",
                "io.kotest",
                "kotest-framework-datatest-jvm",
            ).versionRef("kotest")
            bundle(
                "kotest", listOf(
                    "kotest-runner-junit5",
                    "kotest-framework-datatest",
                )
            )
        }
    }
}
