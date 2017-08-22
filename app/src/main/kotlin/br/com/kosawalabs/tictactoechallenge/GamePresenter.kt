package br.com.kosawalabs.tictactoechallenge

class GamePresenter(val view: Contract.View, val model: Contract.Model) : Contract.Presenter {

    override fun start() {
        view.startGame()
    }

    override fun onClicked(position: Int) {
        model.markCross(position)
    }

    override fun getMark(position: Int): Int = model.getMark(position)

    override fun getBoardSize(): Int = model.getBoardSize()
}
