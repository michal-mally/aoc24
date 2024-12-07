package pl.helenium.aoc24.puzzle.day07.part1

import kotlin.math.pow

class Day07Part1Solver {

    fun solve(input: Sequence<String>): Long {
        return input
            .sumOf { line ->
                val (resultAsString, operandsAsString) = line.split(": ")
                val result = resultAsString.toLong()
                val operands = operandsAsString
                    .split(" ")
                    .map { it.toLong() }

                println(operands)
                val limit = 2
                    .toDouble()
                    .pow(operands.size - 1)
                    .toLong()
                println(limit)
                for (i in 0 until limit) {
                    var sum = operands.first()
                    val bitRep = i
                        .toString(2)
                        .padStart(operands.size - 1, '0')
                    operands
                        .drop(1)
                        .forEachIndexed { index, l ->
                            sum = when (bitRep[index]) {
                                '0' -> sum + l
                                else -> sum * l
                            }
                        }

                    if (sum == result) {
                        println(result)
                        return@sumOf result
                    }
                }

                return@sumOf 0
            }

    }

}
