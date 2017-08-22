package br.com.kosawalabs.tictactoechallenge

import java.security.SecureRandom
import java.util.*

class DumbRobot(private val presenter: Contract.Presenter, private val boardSize: Int) {
    private val random: Random

    init {
        random = SecureRandom()
    }

    fun playMove() {
        presenter.onRobotPlay(random.nextInt(boardSize))
    }
}
