package pl.helenium.aoc24.puzzle.day08.part1

import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.board
import pl.helenium.aoc24.util.pairs

class Day08Part1Solver {

    fun solve(input: Sequence<String>): Int =
        with(board(input)) {
            allCellsWithValues()
                .filterNot { (_, value) -> value == '.' }
                .groupBy { (_, value) -> value }
                .values
                .map { it.map(Pair<Cell, Char>::first) }
                .flatMapTo(mutableSetOf()) { antinodes(it) }
                .count { it in this }
        }

    private fun antinodes(nodes: List<Cell>) =
        nodes
            .pairs()
            .flatMap { (a, b) -> (b - a).let { diff -> sequenceOf(a - diff, b + diff) } }

}
