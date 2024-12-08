package pl.helenium.aoc24.puzzle.day08.part1

import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.board

class Day08Part1Solver {

    fun solve(input: Sequence<String>): Int {
        val board = board(input)
        return board
            .allCells()
            .filterNot { board[it] == '.' }
            .map { it to board[it] }
            .groupBy { (_, value) -> value }
            .values
            .map { it.map { (cell, _) -> cell } }
            .flatMap { antinodes(it) }
            .toSet()
            .count { it in board }
    }

    private fun antinodes(nodes: List<Cell>) =
        buildSet {
            for (i in nodes.indices) {
                for (j in i + 1 until nodes.size) {
                    val a = nodes[i]
                    val b = nodes[j]
                    val diff = b - a
                    add(a - diff)
                    add(b + diff)
                }
            }
        }

}
