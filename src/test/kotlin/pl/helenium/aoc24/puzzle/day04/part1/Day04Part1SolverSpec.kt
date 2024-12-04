package pl.helenium.aoc24.puzzle.day04.part1

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class Day04Part1SolverSpec : FunSpec({

    val day = 4

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 18L,
            real(day) to 2599L,
        ) { (input, expected) ->
            // expect
            Day04Part1Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
