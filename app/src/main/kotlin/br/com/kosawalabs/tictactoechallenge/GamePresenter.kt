package br.com.kosawalabs.tictactoechallenge

class GamePresenter(val view: Contract.View, val model: Contract.Model) : Contract.Presenter {
    override lateinit var robot: DumbRobot

    override fun start() {
        model.start()
        view.startGame()
    }

    override fun onClicked(position: Int) {
        if (model.hasFinishedTheGame()) {
            view.showEndGameMessage("None")
            return
        }

        if (model.markCross(position)) {
            view.updateView(position)
            if(model.hasCrossWonTheGame()){
                view.showEndGameMessage("Cross")
                return
            }
            robot.playMove()
        }
    }

    override fun onRobotPlay(position: Int) {
        if (model.hasFinishedTheGame()) {
            view.showEndGameMessage("None")
            return
        }

        if (model.markCircle(position)) {
            view.updateView(position)
            if(model.hasCircleWonTheGame()){
                view.showEndGameMessage("Circle")
                return
            }
        } else {
            robot.playMove()
        }
    }

    override fun getMark(position: Int): Int = model.getMark(position)

    override fun getBoardSize(): Int = model.getBoardSize()
}
