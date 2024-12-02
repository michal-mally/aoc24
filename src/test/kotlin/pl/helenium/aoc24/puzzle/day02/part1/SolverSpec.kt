package pl.helenium.aoc24.puzzle.day02.part1

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class SolverSpec : FunSpec({

    val day = 2

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 2,
            real(day) to 3246517,
        ) { (input, expected) ->
            // expect
            Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
