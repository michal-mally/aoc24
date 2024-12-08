package pl.helenium.aoc24.puzzle.day08

import pl.helenium.aoc24.util.board.Board
import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.board
import pl.helenium.aoc24.util.pairs

fun solve(
    input: Sequence<String>,
    antinodesGenerator: (Cell, Cell) -> Sequence<Sequence<Cell>>,
): Int =
    with(board(input)) {
        groupCellsByValue()
            .flatMap { it.pairs() }
            .flatMap { (a, b) -> antinodesGenerator(a, b) }
            .flatMapTo(mutableSetOf()) { it.takeWhile { cell -> cell in this } }
            .count { it in this }
    }

private fun Board<Char>.groupCellsByValue(): Sequence<Set<Cell>> =
    allCellsWithValues()
        .filterNot { (_, value) -> value == '.' }
        .groupBy { (_, value) -> value }
        .values
        .asSequence()
        .map { it.mapTo(mutableSetOf()) { (cell, _) -> cell } }
