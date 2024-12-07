package pl.helenium.aoc24.puzzle.day07

import pl.helenium.aoc24.util.mapFirst
import pl.helenium.aoc24.util.mapSecond
import pl.helenium.aoc24.util.pow
import pl.helenium.aoc24.util.toPair

fun solve(input: Sequence<String>, operators: List<(Long, Long) -> Long>): Long =
    input
        .map { it.toExpectedResultAndOperands() }
        .filter { (expectedResult, operands) -> canResultBeAchieved(operators, expectedResult, operands) }
        .sumOf { it.first }

private fun String.toExpectedResultAndOperands() =
    split(": ")
        .toPair()
        .mapFirst { it.toLong() }
        .mapSecond { it.split(" ") }
        .mapSecond { it.map(String::toLong) }

private fun canResultBeAchieved(
    operators: List<(Long, Long) -> Long>,
    expectedResult: Long,
    operands: List<Long>,
): Boolean {
    val possibilities = operators
        .size
        .pow(operands.size - 1)

    return (0 until possibilities).any { canResultBeAchieved(operators, expectedResult, operands, it) }
}

private fun canResultBeAchieved(
    operators: List<(Long, Long) -> Long>,
    expectedResult: Long,
    operands: List<Long>,
    possibility: Long,
): Boolean {
    val placeholderOperators = possibility
        .toString(operators.size)
        .padStart(operands.size - 1, '0')
        .map { it.digitToInt() }
        .map { operators[it] }

    var result = operands.first()
    for (index in placeholderOperators.indices) {
        val operator = placeholderOperators[index]
        val operand = operands[index + 1]
        result = operator(result, operand)

        if (result > expectedResult) {
            return false
        }
    }

    return result == expectedResult
}
