package pl.helenium.aoc24.puzzle.day08

import pl.helenium.aoc24.util.addAndReturnSet
import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.board
import pl.helenium.aoc24.util.pairs

fun solve(
    input: Sequence<String>,
    antinodesGenerator: (Cell, Cell) -> Sequence<Sequence<Cell>>,
): Int =
    with(board(input)) {
        allCellsWithValues()
            .filterNot { (_, value) -> value == '.' }
            .groupingBy { (_, value) -> value }
            .fold({ _, _ -> mutableSetOf<Cell>() }) { _, acc, (cell, _) ->
                acc.addAndReturnSet(cell)
            }
            .values
            .flatMap {
                it
                    .pairs()
                    .flatMap { (a, b) -> antinodesGenerator(a, b) }
            }
            .flatMapTo(mutableSetOf()) { it.takeWhile { cell -> cell in this } }
            .count { it in this }
    }
