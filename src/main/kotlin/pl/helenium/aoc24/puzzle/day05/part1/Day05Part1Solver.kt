package pl.helenium.aoc24.puzzle.day05.part1

import pl.helenium.aoc24.util.Inputs.Companion.splitByEmptyLines

class Day05Part1Solver {

    fun solve(input: Sequence<String>): Long {
        val (dependencies, updates) = splitByEmptyLines(input)

        val deps = dependencies
            .map { it.split("|") }
            .map { it.map { it.toLong() } }
            .map { (left, right) -> left to right }
            .groupBy { it.second }
            .mapValues { it.value.map { it.first }.toSet() }

        return updates
            .map { it.split(",") }
            .map { it.map { it.toLong() } }
            .filter { valid(deps, it) }
            .sumOf { it[it.size / 2] }
    }

    private fun valid(deps: Map<Long, Set<Long>>, x: List<Long>): Boolean {
        val before = mutableSetOf<Long>()

        for (element in x) {
            if (element in before) {
                return false
            }

            before.addAll(deps[element] ?: emptySet())
        }

        return true
    }

}
