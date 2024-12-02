package pl.helenium.aoc24.puzzle.day01.part1

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class Day01Part1SolverSpec : FunSpec({

    val day = 1

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 11L,
            real(day) to 3246517L,
        ) { (input, expected) ->
            // expect
            Day01Part1Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
