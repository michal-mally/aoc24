package pl.helenium.aoc24.util

import kotlin.math.pow

fun Int.pow(exponent: Int) =
    toDouble()
        .pow(exponent)
        .toLong()
