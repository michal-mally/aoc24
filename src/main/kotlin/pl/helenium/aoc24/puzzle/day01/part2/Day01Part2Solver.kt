package pl.helenium.aoc24.puzzle.day01.part2

import pl.helenium.aoc24.util.Inputs.Companion.verticalLists

class Day01Part2Solver {

    fun solve(input: Sequence<String>): Long {
        val (lefts, rights) = verticalLists(input, 2, String::toLong)

        val rightCounted = rights
            .groupingBy { it }
            .eachCount()
            .withDefault { 0 }

        return lefts.sumOf { rightCounted.getValue(it) * it }
    }

}
