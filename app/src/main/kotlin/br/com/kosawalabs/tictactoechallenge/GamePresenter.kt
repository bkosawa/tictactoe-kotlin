package br.com.kosawalabs.tictactoechallenge

class GamePresenter : Contract.Presenter {
    lateinit var view: Contract.View
    lateinit var model: Contract.Model

    override fun start() {
        view.startGame()
    }

    override fun onClicked(position: Int) {
        model.markCross(position)
    }
}
