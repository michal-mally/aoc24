package pl.helenium.aoc24.puzzle.day03.part2

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.text

class Day03Part2SolverSpec : FunSpec({

    val day = 3

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 48L,
            real(day) to 92626942L,
        ) { (input, expected) ->
            // expect
            Day03Part2Solver().solve(text(input)) shouldBeEqual expected
        }
    }

})
