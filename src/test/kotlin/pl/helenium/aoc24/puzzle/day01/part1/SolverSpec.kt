package pl.helenium.aoc24.puzzle.day01.part1

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

private const val DAY = 1

class SolverSpec : FunSpec({

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(DAY) to 11L,
            real(DAY) to 3246517L,
        ) { (input, expected) ->
            // expect
            Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
