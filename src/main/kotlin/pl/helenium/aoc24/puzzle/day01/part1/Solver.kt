package pl.helenium.aoc24.puzzle.day01.part1

import kotlin.math.abs

class Solver {

    fun solve(input: Sequence<String>): Long {
        val lefts = mutableListOf<Long>()
        val rights = mutableListOf<Long>()
        input
            .filterNot { it.isBlank() }
            .forEach { line ->
                val (left, right) = line
                    .split(Regex("""\s+"""))
                    .map(String::toLong)
                lefts += left
                rights += right
            }

        lefts.sort()
        rights.sort()

        return lefts
            .zip(rights)
            .sumOf { (left, right) -> abs(left - right) }
    }

}
