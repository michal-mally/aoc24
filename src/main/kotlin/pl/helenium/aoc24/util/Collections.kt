package pl.helenium.aoc24.util

fun <T> Collection<T>.toPair(): Pair<T, T> =
    if (size == 2) first() to last() else throw IllegalArgumentException("Collection must have exactly 2 elements")

fun <T, U, V> Pair<T, U>.mapFirst(f: (T) -> V): Pair<V, U> =
    f(first) to second

fun <T, U, V> Pair<T, U>.mapSecond(f: (U) -> V): Pair<T, V> =
    first to f(second)

fun <T, U> Pair<T, T>.map(f: (T) -> U): Pair<U, U> =
    f(first) to f(second)

fun <T> Collection<T>.pairs() =
    toList().let {
        sequence {
            for (i in indices) {
                for (j in i + 1 until size) {
                    yield(it[i] to it[j])
                }
            }
        }
    }
