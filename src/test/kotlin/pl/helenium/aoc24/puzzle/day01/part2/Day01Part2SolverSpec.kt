package pl.helenium.aoc24.puzzle.day01.part2

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class Day01Part2SolverSpec : FunSpec({

    val day = 1

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 31L,
            real(day) to 29379307L,
        ) { (input, expected) ->
            // expect
            Day01Part2Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
