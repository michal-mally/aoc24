package pl.helenium.aoc24.puzzle.day07.part2

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import pl.helenium.aoc24.util.Input.Companion.example
import pl.helenium.aoc24.util.Input.Companion.real
import pl.helenium.aoc24.util.Resources.Companion.linesAsSequence

class Day07Part2SolverSpec : FunSpec({

    val day = 7

    context("should solve the puzzle") {
        withData(
            nameFn = { (input, _) -> input.type },
            example(day) to 11387L,
            real(day) to 223472064194845L,
        ) { (input, expected) ->
            // expect
            Day07Part2Solver().solve(linesAsSequence(input)) shouldBeEqual expected
        }
    }

})
