package pl.helenium.aoc24.puzzle.day06.part2

import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.Direction
import pl.helenium.aoc24.util.board.Directions.Companion.UP
import pl.helenium.aoc24.util.board.board
import pl.helenium.aoc24.util.board.rotateClockwise

class Day06Part2Solver {

    fun solve(input: Sequence<String>): Int {
        val originalBoard = board(input)

        return originalBoard
            .filter { it == '.' }
            .count { cell ->
                val board = originalBoard
                    .copy()
                    .apply { this[cell] = '#' }

                var location = board.first { it == '^' }
                var direction = UP
                val distinctLocationsAndDirections = mutableSetOf<Pair<Cell, Direction>>()
                while (location to direction !in distinctLocationsAndDirections) {
                    distinctLocationsAndDirections += location to direction

                    val nextLocation = location + direction
                    if (nextLocation !in board) {
                        return@count false
                    }

                    if (board[nextLocation] == '#') {
                        direction = direction.rotateClockwise()
                        continue
                    }

                    location = nextLocation
                }

                return@count true
            }
    }

}
