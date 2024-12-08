package pl.helenium.aoc24.puzzle.day08.part2

import pl.helenium.aoc24.puzzle.day08.solve

class Day08Part2Solver {

    fun solve(input: Sequence<String>): Int =
        solve(input) { board, a, b ->
            val diff = b - a
            generateSequence(a) { it - diff }.takeWhile { it in board } + generateSequence(b) { it + diff }.takeWhile { it in board }
        }

}
