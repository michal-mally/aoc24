package pl.helenium.aoc24.util

class Inputs {

    companion object {
        fun <T> verticalLists(
            input: Sequence<String>,
            numberOfLists: Int,
            mapper: (String) -> T,
        ): List<List<T>> =
            List(numberOfLists) { mutableListOf<T>() }.apply {
                input.forEach { line ->
                    line
                        .split(Regex("""\s+"""))
                        .forEachIndexed { index, s ->
                            this[index] += mapper(s)
                        }

                }
            }

        fun splitByEmptyLines(input: Sequence<String>): List<List<String>> =
            mutableListOf<MutableList<String>>().apply {
                add(mutableListOf())

                input.forEach { line ->
                    if (line.isBlank()) {
                        this += mutableListOf<String>()
                    } else {
                        last() += line
                    }
                }
            }

    }

}
