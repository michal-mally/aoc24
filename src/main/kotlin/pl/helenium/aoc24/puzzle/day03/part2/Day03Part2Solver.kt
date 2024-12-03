package pl.helenium.aoc24.puzzle.day03.part2

class Day03Part2Solver {

    fun solve(input: String): Long {
        var enabled = true
        var sum = 0L
        for (token in Regex("""mul\((\d+),(\d+)\)|do\(\)|don't\(\)""").findAll(input)) {
            when(token.value) {
                "do()" -> enabled = true
                "don't()" -> enabled = false
                else -> {
                    if (enabled) {
                        val (a, b) = token.destructured
                        sum += a.toLong() * b.toLong()
                    }
                }
            }
        }

        return sum
    }
}
