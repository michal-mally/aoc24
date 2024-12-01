package pl.helenium.aoc24.puzzle.day01.part1

import pl.helenium.aoc24.util.Inputs.Companion.verticalLists
import kotlin.math.abs

class Solver {

    fun solve(input: Sequence<String>): Long {
        val (lefts, rights) = verticalLists(input, 2, String::toLong).map { it.sorted() }

        return lefts
            .zip(rights)
            .sumOf { (left, right) -> abs(left - right) }
    }

}
