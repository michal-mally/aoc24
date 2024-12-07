package pl.helenium.aoc24.puzzle.day07.part1

import pl.helenium.aoc24.puzzle.day07.solve

class Day07Part1Solver {

    fun solve(input: Sequence<String>): Long {
        return solve(
            input,
            listOf(
                Long::plus,
                Long::times,
            ),
        )
    }

}
