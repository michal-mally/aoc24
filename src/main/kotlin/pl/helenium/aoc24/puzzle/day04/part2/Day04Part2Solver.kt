package pl.helenium.aoc24.puzzle.day04.part2

import pl.helenium.aoc24.util.board.Board
import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.board

class Day04Part2Solver {

    private val diagonals = setOf(1, -1)

    fun solve(input: Sequence<String>): Int =
        with(board(input)) {
            allCells()
                .filter { this[it] == 'A' }
                .count { center ->
                    diagonals.all { masDiagonal(center, it) }
                }
        }

    private fun Board<Char>.masDiagonal(center: Cell, diagonal: Int): Boolean {
        require(diagonal in diagonals) { "Diagonal must be 1 or -1" }

        return diagonals
            .map { Cell(it, it * diagonal) }
            .map { center + it }
            .takeIf { cells -> cells.all { it in this } }
            ?.map { this[it] }
            ?.containsAll(setOf('M', 'S'))
            ?: false
    }

}
