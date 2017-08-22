package br.com.kosawalabs.tictactoechallenge

class Contract {
    interface View {
        var presenter: Presenter
        fun startGame()
        fun updateView(position: Int)
        fun showEndGameMessage(winner: String)
    }

    interface Presenter {
        var robot: DumbRobot
        fun start()
        fun onClicked(position: Int)
        fun onRobotPlay(position: Int)
        fun getMark(position: Int): Int
        fun getBoardSize(): Int
    }

    interface Model {
        fun hasFinishedTheGame(): Boolean
        fun markCross(position: Int): Boolean
        fun markCircle(position: Int): Boolean
        fun getMark(position: Int): Int
        fun getBoardSize(): Int
        fun start()
        fun hasCrossWonTheGame(): Boolean
        fun hasCircleWonTheGame(): Boolean
    }

    companion object Injector {
        fun inject(view: View) {
            val model = GameModel()
            val presenter = GamePresenter(view, model)

            presenter.robot = DumbRobot(presenter, GameModel.BOARD_SIZE)
            view.presenter = presenter
            model.presenter = presenter
        }
    }
}
