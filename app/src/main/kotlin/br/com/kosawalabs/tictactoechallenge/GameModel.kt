package br.com.kosawalabs.tictactoechallenge

class GameModel : Contract.Model {

    lateinit var presenter: Contract.Presenter
    var markedPositionsMap: MutableMap<Int, Int> = mutableMapOf()

    init {
        for (i in 0 until BOARD_SIZE) { markedPositionsMap[i] = POSITION_EMPTY }
    }

    override fun markCross(position: Int) {
        markedPositionsMap[position] = POSITION_CROSS
    }

    override fun getMark(position: Int): Int = markedPositionsMap[position]!!

    companion object {
        val BOARD_SIZE = 9
        val POSITION_EMPTY = 0
        val POSITION_CROSS = 3
        val POSITION_CIRCLE = 5
    }
}
