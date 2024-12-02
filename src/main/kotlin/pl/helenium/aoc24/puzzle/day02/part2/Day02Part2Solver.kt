package pl.helenium.aoc24.puzzle.day02.part2

import kotlin.math.abs

class Day02Part2Solver {

    fun solve(input: Sequence<String>): Int {
        return input
            .count { line ->
                val numbers = line
                    .split(" ")
                    .map(String::toLong)
                isSafe(numbers) || isSafe(numbers.reversed())
            }
    }

    private fun isSafe(numbers: List<Long>): Boolean {
        var lastElement = numbers.first()
        var sign: Long? = null
        var elementRemoved = false
        for (index in 1 until numbers.size) {
            val currentElement = numbers[index]
            val diff = currentElement - lastElement
            if (sign == null) {
                sign = diff
            }
            if (abs(diff) > 3 || diff * sign <= 0) {
                if (elementRemoved) {
                    return false
                }
                elementRemoved = true
                if (index == 1) {
                    sign = null
                }
                continue
            }

            lastElement = currentElement
        }

        return true
    }

}
