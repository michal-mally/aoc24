package pl.helenium.aoc24.puzzle.day06.part1

import pl.helenium.aoc24.util.board.Directions.Companion.UP
import pl.helenium.aoc24.util.board.board
import pl.helenium.aoc24.util.board.rotateClockwise

class Day06Part1Solver {

    fun solve(input: Sequence<String>) =
        with(board(input)) {
            var location = first { it == '^' }
            var direction = UP
            val visitedLocations = mutableSetOf(location)
            while (true) {
                val nextLocation = location + direction
                if (nextLocation !in this) {
                    return@with visitedLocations.size
                }

                if (this[nextLocation] == '#') {
                    direction = direction.rotateClockwise()
                    continue
                }

                location = nextLocation
                visitedLocations += location
            }
        }

}
