package pl.helenium.aoc24.puzzle.day02.part1

import kotlin.math.abs

class Day02Part1Solver {

    fun solve(input: Sequence<String>): Int {
        return input
            .count { line -> isSafe(line) }
    }

    private fun isSafe(line: String): Boolean {
        val toList = line
            .splitToSequence(" ")
            .map { it.toLong() }
            .zipWithNext { a, b -> b - a }
            .toList()

        if ((toList.any { it < 0 } && toList.any { it > 0 }) || toList.any { it == 0L }) {
            return false
        }

        if (toList.any { abs(it) > 3L }) {
            return false
        }

        return true
    }

}
