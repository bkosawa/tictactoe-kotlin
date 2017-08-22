package br.com.kosawalabs.tictactoechallenge

class GameModel : Contract.Model {

    lateinit var presenter: Contract.Presenter
    var markedPositionsMap: MutableMap<Int, Int> = mutableMapOf()
    var rounds = 0

    init {
        start()
    }

    override fun start() {
        for (i in 0 until BOARD_SIZE) { markedPositionsMap[i] = POSITION_EMPTY }
    }

    override fun hasFinishedTheGame(): Boolean = rounds >= BOARD_SIZE

    override fun hasCrossWonTheGame(): Boolean = hasWonTheGame(POSITION_CROSS)

    override fun hasCircleWonTheGame(): Boolean = hasWonTheGame(POSITION_CIRCLE)

    override fun markCross(position: Int): Boolean = mark(position, POSITION_CROSS)

    override fun markCircle(position: Int): Boolean = mark(position, POSITION_CIRCLE)

    override fun getMark(position: Int): Int = markedPositionsMap[position]!!

    override fun getBoardSize(): Int = BOARD_SIZE

    private fun mark(position: Int, mark: Int): Boolean {
        return if (markedPositionsMap[position]!! == POSITION_EMPTY) {
            markedPositionsMap[position] = mark
            rounds++
            true
        } else {
            false
        }
    }

    fun hasWonTheGame(mark: Int): Boolean {
        return (markedPositionsMap[0]!! == mark &&
                markedPositionsMap[1]!! == mark &&
                markedPositionsMap[2]!! == mark)

                || (markedPositionsMap[3]!! == mark &&
                markedPositionsMap[4]!! == mark &&
                markedPositionsMap[5]!! == mark)

                || (markedPositionsMap[6]!! == mark &&
                markedPositionsMap[7]!! == mark &&
                markedPositionsMap[8]!! == mark)

                || (markedPositionsMap[0]!! == mark &&
                markedPositionsMap[3]!! == mark &&
                markedPositionsMap[6]!! == mark)

                || (markedPositionsMap[1]!! == mark &&
                markedPositionsMap[4]!! == mark &&
                markedPositionsMap[7]!! == mark)

                || (markedPositionsMap[2]!! == mark &&
                markedPositionsMap[5]!! == mark &&
                markedPositionsMap[8]!! == mark)

                || (markedPositionsMap[0]!! == mark &&
                markedPositionsMap[4]!! == mark &&
                markedPositionsMap[8]!! == mark)

                || (markedPositionsMap[3]!! == mark &&
                markedPositionsMap[4]!! == mark &&
                markedPositionsMap[6]!! == mark)
    }

    companion object {
        val BOARD_SIZE = 9
        val POSITION_EMPTY = 0
        val POSITION_CROSS = 3
        val POSITION_CIRCLE = 5
    }
}
