package br.com.kosawalabs.tictactoechallenge

class GameModel : Contract.Model {

    lateinit var presenter: Contract.Presenter
    var markedPositionsMap: MutableMap<Int, Int> = mutableMapOf()

    init {
        for (i in 0 until BOARD_SIZE) { markedPositionsMap[i] = POSITION_EMPTY }
    }

    override fun markCross(position: Int): Boolean {
        return mark(position, POSITION_CROSS)
    }

    override fun markCircle(position: Int): Boolean {
        return mark(position, POSITION_CIRCLE)
    }

    override fun getMark(position: Int): Int = markedPositionsMap[position]!!

    override fun getBoardSize(): Int = BOARD_SIZE

    private fun mark(position: Int, mark: Int): Boolean {
        return if (markedPositionsMap[position]!! == POSITION_EMPTY) {
            markedPositionsMap[position] = mark
            true
        } else {
            false
        }
    }

    companion object {
        val BOARD_SIZE = 9
        val POSITION_EMPTY = 0
        val POSITION_CROSS = 3
        val POSITION_CIRCLE = 5
    }
}
