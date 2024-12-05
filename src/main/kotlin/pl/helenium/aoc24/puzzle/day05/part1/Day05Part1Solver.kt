package pl.helenium.aoc24.puzzle.day05.part1

import pl.helenium.aoc24.util.Inputs.Companion.splitByEmptyLines
import pl.helenium.aoc24.util.map
import pl.helenium.aoc24.util.mapFirst
import pl.helenium.aoc24.util.mapSecond
import pl.helenium.aoc24.util.toPair

class Day05Part1Solver {

    fun solve(input: Sequence<String>): Long {
        val (dependencies, updates) = splitByEmptyLines(input)
            .toPair()
            .mapFirst { first ->
                fun String.toDependency() =
                    split("|")
                        .toPair()
                        .map { it.toLong() }

                first
                    .map { it.toDependency() }
                    .groupBy { it.second }
                    .mapValues { (_, value) ->
                        value
                            .map { it.first }
                            .toSet()
                    }
            }
            .mapSecond { second ->
                second
                    .map { it.split(",") }
                    .map { it.map { it.toLong() } }
            }

        return updates
            .filter { valid(dependencies, it) }
            .sumOf { it[it.size / 2] }
    }

    private fun valid(dependencies: Map<Long, Set<Long>>, updates: List<Long>): Boolean {
        val before = mutableSetOf<Long>()

        for (element in updates) {
            if (element in before) {
                return false
            }

            before.addAll(dependencies[element] ?: emptySet())
        }

        return true
    }

}
