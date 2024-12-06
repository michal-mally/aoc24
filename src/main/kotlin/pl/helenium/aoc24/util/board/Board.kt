package pl.helenium.aoc24.util.board

class Board<T>(cells: List<List<T>>) {

    private val cells: List<MutableList<T>>

    init {
        require(cells.isNotEmpty()) { "Board must have at least one row" }
        require(
            cells
                .first()
                .isNotEmpty()
        ) { "Board must have at least one column" }
        require(cells.all { it.size == cells.first().size }) { "All rows must have the same size" }

        this.cells = cells.map { it.toMutableList() }
    }

    private val rows = cells.size

    private val columns = cells.first().size

    operator fun get(cell: Cell): T =
        this[cell.row, cell.column]

    operator fun get(row: Int, column: Int): T {
        requireCellInBoard(row, column)

        return cells[row][column]
    }

    operator fun set(cell: Cell, value: T) {
        this[cell.row, cell.column] = value
    }

    operator fun set(row: Int, column: Int, value: T) {
        requireCellInBoard(row, column)

        cells[row][column] = value
    }

    operator fun contains(cell: Cell): Boolean =
        cell.row in 0 until rows && cell.column in 0 until columns

    fun allCells() =
        sequence {
            for (row in 0 until rows) {
                for (column in 0 until columns) {
                    yield(Cell(row, column))
                }
            }
        }

    private fun requireCellInBoard(row: Int, column: Int) {
        require(row in 0 until rows) { "Row index out of bounds: $row" }
        require(column in 0 until columns) { "Column index out of bounds: $column" }
    }

}

fun board(input: Sequence<String>) =
    input
        .map(String::toCharArray)
        .map(CharArray::toList)
        .toList()
        .let(::Board)
