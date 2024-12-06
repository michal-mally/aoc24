package pl.helenium.aoc24.puzzle.day06.part1

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class Day06Part1SolverSpec : FunSpec({

    val day = 6

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 41,
            real(day) to 4722,
        ) { (input, expected) ->
            // expect
            Day06Part1Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
