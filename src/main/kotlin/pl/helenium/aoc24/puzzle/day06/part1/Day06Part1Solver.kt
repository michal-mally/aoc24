package pl.helenium.aoc24.puzzle.day06.part1

import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.board

class Day06Part1Solver {

    fun solve(input: Sequence<String>): Int {
        val board = board(input)

        var currentLocation = board.allCells().first { board[it] == '^' }
        var direction = Cell(-1, 0)
        val distinctLocations = mutableSetOf(currentLocation)
        while (true) {
            val nextLocation = currentLocation + direction
            if (nextLocation !in board) {
                break
            }

            if (board[nextLocation] == '#') {
                direction = Cell(direction.column, -direction.row)
                continue
            }

            currentLocation = nextLocation
            distinctLocations += currentLocation
        }

        return distinctLocations.size
    }

}
