package pl.helenium.aoc24.puzzle.day04.part1

import pl.helenium.aoc24.util.board.Board
import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.Direction
import pl.helenium.aoc24.util.board.Directions.Companion.ALL_DIRECTIONS
import pl.helenium.aoc24.util.board.board

class Day04Part1Solver {

    fun solve(input: Sequence<String>): Long =
        with(board(input)) {
            allCells()
                .flatMap { cell -> ALL_DIRECTIONS.map { cell to it } }
                .sumOf { (cell, direction) ->
                    backtrack(cell, direction, "XMAS")
                }
        }

    private fun Board<Char>.backtrack(
        cell: Cell,
        direction: Direction,
        searched: String,
    ): Long {
        if (searched.isEmpty()) {
            return 1L
        }

        if (cell !in this) {
            return 0L
        }

        if (this[cell] != searched.first()) {
            return 0L
        }

        return backtrack(cell + direction, direction, searched.drop(1))
    }

}
