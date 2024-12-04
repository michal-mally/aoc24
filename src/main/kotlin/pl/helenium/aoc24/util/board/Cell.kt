package pl.helenium.aoc24.util.board

data class Cell(val row: Int, val column: Int) {
    operator fun plus(other: Cell) =
        Cell(row + other.row, column + other.column)
}

fun directions() =
    Cell(0, 0).adjacents()

fun Cell.adjacents() =
    sequenceOf(
        Cell(row - 1, column - 1),
        Cell(row - 1, column),
        Cell(row - 1, column + 1),
        Cell(row, column - 1),
        Cell(row, column + 1),
        Cell(row + 1, column - 1),
        Cell(row + 1, column),
        Cell(row + 1, column + 1)
    )
