package pl.helenium.aoc24.puzzle.day02.part2

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class Day02Part2SolverSpec : FunSpec({

    val day = 2

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 4,
            real(day) to 700,
        ) { (input, expected) ->
            // expect
            Day02Part2Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
