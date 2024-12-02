package pl.helenium.aoc24.util

class Inputs {
    companion object {
        fun <T> verticalLists(
            input: Sequence<String>,
            numberOfLists: Int,
            mapper: (String) -> T,
        ): List<List<T>> {
            val result = List(numberOfLists) { mutableListOf<T>() }

            input.forEach { line ->
                line
                    .split(Regex("""\s+"""))
                    .forEachIndexed { index, s ->
                        result[index] += mapper(s)
                    }

            }

            return result
        }
    }
}
