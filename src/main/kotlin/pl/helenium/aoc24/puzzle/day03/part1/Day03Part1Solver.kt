package pl.helenium.aoc24.puzzle.day03.part1

class Day03Part1Solver {

    fun solve(input: String): Long =
        Regex("""mul\((\d+),(\d+)\)""")
            .findAll(input)
            .map { it.destructured }
            .map { (a, b) -> a.toLong() to b.toLong() }
            .sumOf { (a, b) -> a * b }

}
