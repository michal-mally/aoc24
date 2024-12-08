package pl.helenium.aoc24.puzzle.day08.part2

import pl.helenium.aoc24.util.board.Board
import pl.helenium.aoc24.util.board.Cell
import pl.helenium.aoc24.util.board.board

class Day08Part2Solver {

    fun solve(input: Sequence<String>): Int {
        val board = board(input)
        return board
            .allCells()
            .filterNot { board[it] == '.' }
            .map { it to board[it] }
            .groupBy { (_, value) -> value }
            .values
            .map { it.map { (cell, _) -> cell } }
            .flatMap { antinodes(board, it) }
            .toSet()
            .count()
    }

    private fun antinodes(board: Board<*>, nodes: List<Cell>) =
        buildSet {
            for (i in nodes.indices) {
                for (j in i + 1 until nodes.size) {
                    val a = nodes[i]
                    val b = nodes[j]
                    val diff = b - a
                    var aMinus = a
                    while (aMinus in board) {
                        add(aMinus)
                        aMinus -= diff
                    }

                    var bPlus = b
                    while (bPlus in board) {
                        add(bPlus)
                        bPlus += diff
                    }
                }
            }
        }

}
