package pl.helenium.aoc24.util.board

data class Cell(val row: Int, val column: Int) {
    operator fun plus(other: Cell) =
        Cell(row + other.row, column + other.column)
}

fun Cell.rotateClockwise() =
    Cell(column, -row)
