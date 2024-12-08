package pl.helenium.aoc24.puzzle.day08.part2

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class Day08Part2SolverSpec : FunSpec({

    val day = 8

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 34,
            real(day) to 1131,
        ) { (input, expected) ->
            // expect
            Day08Part2Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
