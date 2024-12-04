package pl.helenium.aoc24.puzzle.day04.part2

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class Day04Part2SolverSpec : FunSpec({

    val day = 4

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 9,
            real(day) to 1948,
        ) { (input, expected) ->
            // expect
            Day04Part2Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
