package pl.helenium.aoc24.puzzle.day08

import pl.helenium.aoc24.util.addAndReturnSet
import pl.helenium.aoc24.util.board.Board
import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.board
import pl.helenium.aoc24.util.pairs

fun solve(
    input: Sequence<String>,
    antinodesGenerator: (Board<*>, Cell, Cell) -> Sequence<Cell>,
): Int =
    with(board(input)) {
        allCellsWithValues()
            .filterNot { (_, value) -> value == '.' }
            .groupingBy { (_, value) -> value }
            .fold({ _, _ -> mutableSetOf<Cell>() }) { _, acc, (cell, _) ->
                acc.addAndReturnSet(cell)
            }
            .values
            .flatMapTo(mutableSetOf()) { nodes ->
                this.antinodes(nodes, antinodesGenerator)
            }
            .count { it in this }
    }

private fun Board<*>.antinodes(
    nodes: Set<Cell>,
    antinodesGenerator: (Board<*>, Cell, Cell) -> Sequence<Cell>,
) =
    nodes
        .pairs()
        .flatMap { (a, b) -> antinodesGenerator(this, a, b) }
