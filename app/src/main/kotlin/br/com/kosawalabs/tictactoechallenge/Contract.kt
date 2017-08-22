package br.com.kosawalabs.tictactoechallenge

class Contract {
    interface View {
        var presenter: Presenter
        fun startGame()
    }

    interface Presenter {
        fun start()
        fun onClicked(position: Int)
        fun getMark(position: Int): Int
        fun getBoardSize(): Int
    }

    interface Model {
        fun hasFinishedTheGame(): Boolean
        fun markCross(position: Int): Boolean
        fun markCircle(position: Int): Boolean
        fun getMark(position: Int): Int
        fun getBoardSize(): Int
    }

    companion object Injector {
        fun inject(view: View) {
            val model = GameModel()
            val presenter = GamePresenter(view, model)

            view.presenter = presenter
            model.presenter = presenter
        }
    }
}
