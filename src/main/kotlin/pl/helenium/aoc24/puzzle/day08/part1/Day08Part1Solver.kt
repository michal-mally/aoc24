package pl.helenium.aoc24.puzzle.day08.part1

import pl.helenium.aoc24.puzzle.day08.solve

class Day08Part1Solver {

    fun solve(input: Sequence<String>): Int =
        solve(input) { a, b ->
            (b - a).let { diff ->
                sequenceOf(
                    sequenceOf(a - diff),
                    sequenceOf(b + diff)
                )
            }
        }

}
