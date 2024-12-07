package pl.helenium.aoc24.puzzle.day07.part2

import pl.helenium.aoc24.puzzle.day07.solve

class Day07Part2Solver {

    fun solve(input: Sequence<String>): Long {
        return solve(
            input,
            listOf(
                Long::plus,
                Long::times,
                { a, b -> "$a$b".toLong() },
            ),
        )
    }

}
