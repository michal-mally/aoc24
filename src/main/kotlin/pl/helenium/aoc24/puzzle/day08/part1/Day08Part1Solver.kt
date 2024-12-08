package pl.helenium.aoc24.puzzle.day08.part1

import pl.helenium.aoc24.util.addAndReturnSet
import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.board
import pl.helenium.aoc24.util.pairs

class Day08Part1Solver {

    fun solve(input: Sequence<String>): Int =
        with(board(input)) {
            allCellsWithValues()
                .filterNot { (_, value) -> value == '.' }
                .groupingBy { (_, value) -> value }
                .fold({ _, _ -> mutableSetOf<Cell>() }) { _, acc, (cell, _) ->
                    acc.addAndReturnSet(cell)
                }
                .values
                .flatMapTo(mutableSetOf()) { antinodes(it) }
                .count { it in this }
        }

    private fun antinodes(nodes: Set<Cell>) =
        nodes
            .pairs()
            .flatMap { (a, b) -> (b - a).let { diff -> sequenceOf(a - diff, b + diff) } }

}
