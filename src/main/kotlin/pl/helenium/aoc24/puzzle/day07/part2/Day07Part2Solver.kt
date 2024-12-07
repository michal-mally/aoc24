package pl.helenium.aoc24.puzzle.day07.part2

import kotlin.math.pow

class Day07Part2Solver {

    fun solve(input: Sequence<String>): Long {
        return input
            .sumOf { line ->
                val (resultAsString, operandsAsString) = line.split(": ")
                val result = resultAsString.toLong()
                val operands = operandsAsString
                    .split(" ")
                    .map { it.toLong() }

                val limit = 3
                    .toDouble()
                    .pow(operands.size - 1)
                    .toLong()
                for (i in 0 until limit) {
                    var sum = operands.first()
                    val bitRep = i
                        .toString(3)
                        .padStart(operands.size - 1, '0')
                    operands
                        .drop(1)
                        .forEachIndexed { index, l ->
                            sum = when (bitRep[index]) {
                                '0' -> sum + l
                                '1' -> sum * l
                                else -> "$sum$l".toLong()
                            }
                        }

                    if (sum == result) {
                        return@sumOf result
                    }
                }

                return@sumOf 0
            }

    }

}
