package pl.helenium.aoc24.puzzle.day08.part2

import pl.helenium.aoc24.puzzle.day08.solve

class Day08Part2Solver {

    fun solve(input: Sequence<String>): Int =
        solve(input) { a, b ->
            val diff = b - a
            sequenceOf(
                generateSequence(a) { it - diff },
                generateSequence(b) { it + diff },
            )
        }

}
