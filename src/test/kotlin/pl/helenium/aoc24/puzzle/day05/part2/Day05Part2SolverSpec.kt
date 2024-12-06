package pl.helenium.aoc24.puzzle.day05.part2

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class Day05Part2SolverSpec : FunSpec({

    val day = 5

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 123L,
            real(day) to 4719L,
        ) { (input, expected) ->
            // expect
            Day05Part2Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
