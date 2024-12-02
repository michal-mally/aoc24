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
        fun linesAsSequence(input: Input): Sequence<String> {
            val path = "/inputs/day${
                input.day
                    .toString()
                    .padStart(2, '0')
            }/${input.type}.txt"
            return object {}.javaClass
                .getResource(path)
                ?.readText()
                ?.lines()
                ?.asSequence()
                ?.filter { it.isNotBlank() }
                ?: error("Resource not found: $path")
        }
    }
}
