package pl.helenium.aoc24.util.board

class Board<T>(private val cells: List<List<T>>) {

    init {
        require(cells.isNotEmpty()) { "Board must have at least one row" }
        require(
            cells
                .first()
                .isNotEmpty()
        ) { "Board must have at least one column" }
        require(cells.all { it.size == cells.first().size }) { "All rows must have the same size" }
    }

    private val rows = cells.size

    private val columns = cells.first().size

    operator fun get(cell: Cell): T =
        get(cell.row, cell.column)

    operator fun get(row: Int, column: Int): T {
        require(row in 0 until rows) { "Row index out of bounds: $row" }
        require(column in 0 until columns) { "Column index out of bounds: $column" }

        return cells[row][column]
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

}
