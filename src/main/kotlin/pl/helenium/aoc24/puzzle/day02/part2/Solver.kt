package pl.helenium.aoc24.puzzle.day02.part2

import pl.helenium.aoc24.puzzle.day02.part1.Solver
import kotlin.math.abs

class Solver {

    fun solve(input: Sequence<String>): Int {
        return input
            .count { line -> isSafe(line) }
    }

    private fun isSafe(line: String): Boolean {
        val toList = line
            .splitToSequence(" ")
            .map { it.toLong() }
            .toList()

        var lastElement = toList.first()
        var sign: Long? = null
        var elementRemoved = false
        for (index in 1 until toList.size) {
            val i = toList[index]
            val diff = i - lastElement
            if (sign == null) {
                sign = diff
            }
            if (abs(diff) > 3 || diff == 0L || diff * sign <= 0) {
                if (elementRemoved) {
                    return Solver().solve(sequenceOf(toList.drop(1).joinToString(" "))) == 1
                }
                elementRemoved = true
                if (index == 1) {
                    sign = null
                }
                continue
            }

            lastElement = i
        }

        return true
    }

}
