package board
import board.Direction.*
import java.lang.IllegalArgumentException
import board.Direction.*

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width)

open class SquareBoardImpl(final override val width: Int): SquareBoard {

    protected val cells = mutableListOf<Cell>()

    init {
        for (i in 1 ..width)
            for( j in 1..width)
                cells.add(Cell(i, j))
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        val index = cells.indexOf(Cell(i,j))
        return cells.find { (it.i == i) and (it.j == j) }
    }

    override fun getCell(i: Int, j: Int): Cell {
        return cells.find { (it.i == i) and (it.j == j) } ?: throw IllegalArgumentException()
    }

    override fun getAllCells(): Collection<Cell> {
        return cells
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        val row = mutableListOf<Cell>()
        jRange.iterator().forEach {
            val cell = getCellOrNull(i, it)
            if (cell != null) row.add(cell)
        }

        return row

    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {

        val column = mutableListOf<Cell>()
        iRange.iterator().forEach {
            val cell = getCellOrNull(it, j)
            if (cell != null) column.add(cell)
        }

        return column
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        return when(direction){
            UP -> getCellOrNull(i-1, j)
            LEFT -> getCellOrNull(i, j-1)
            DOWN -> getCellOrNull(i+1, j)
            RIGHT -> getCellOrNull(i, j+1)
        }
    }

}


class GameBoardImpl<T> (width: Int): GameBoard<T> , SquareBoardImpl(width){
    private var cells01 = mutableMapOf<Cell,T?>();

    init {
        getAllCells().map { cells01.put(Cell(1,2),null) }
    }

    override fun get(cell: Cell): T? {
        return cells01[cell]
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        return this.cells.any { cell -> predicate(get(cell)) }
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        return this.cells.all { cell -> predicate(get(cell)) }
    }
    override fun find(predicate: (T?) -> Boolean): Cell? = cells01.filterValues(predicate).keys.firstOrNull()

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> = cells01.filterValues(predicate).keys

    override fun set(cell: Cell, value: T?) {
        cells01[cell] = value
    }

}
