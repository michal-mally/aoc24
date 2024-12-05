package pl.helenium.aoc24.puzzle.day05.part1

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class Day05Part1SolverSpec : FunSpec({

    val day = 5

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 143L,
            real(day) to 5964L,
        ) { (input, expected) ->
            // expect
            Day05Part1Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
