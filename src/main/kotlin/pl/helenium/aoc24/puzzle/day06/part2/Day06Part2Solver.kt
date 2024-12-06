package pl.helenium.aoc24.puzzle.day06.part2

import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.board

class Day06Part2Solver {

    fun solve(input: Sequence<String>): Int {
        val board1 = board(input)
        return board1
            .allCells()
            .filter { board1[it] == '.' }
            .count { cell ->
                val board = board(input)
                board[cell] = '#'

                var currentLocation = board
                    .allCells()
                    .first { board[it] == '^' }
                var direction = Cell(-1, 0)
                val distinctLocationsAndDirections = mutableSetOf<Pair<Cell, Cell>>()
                while (currentLocation to direction !in distinctLocationsAndDirections) {
                    distinctLocationsAndDirections += currentLocation to direction

                    val nextLocation = currentLocation + direction
                    if (nextLocation !in board) {
                        return@count false
                    }

                    if (board[nextLocation] == '#') {
                        direction = Cell(direction.column, -direction.row)
                        continue
                    }

                    currentLocation = nextLocation
                }

                return@count true
            }
    }

}
