package pl.helenium.aoc24.util

class Input private constructor(
    val day: Int,
    val type: String,
) {
    companion object {
        fun example(day: Int) = Input(day, "example")
        fun real(day: Int) = Input(day, "real")
    }
}

class Resources {
    companion object {
        fun linesAsSequence(input: Input): Sequence<String> =
            text(input)
                .lineSequence()
                .filter { it.isNotBlank() }


        fun text(input: Input): String = object {}.javaClass
            .getResource(path(input))
            ?.readText()
            ?: error("Resource not found: ${path(input)}")

        private fun path(input: Input) =
            "/inputs/day${
                input.day
                    .toString()
                    .padStart(2, '0')
            }/${input.type}.txt"
    }
}
