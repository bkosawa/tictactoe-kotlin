package br.com.kosawalabs.tictactoechallenge

class Contract {
    interface View {
        fun injectPresenter(presenter: Presenter)
        fun startGame()
    }

    interface Presenter {
        fun start()
        fun onClicked(position: Int)
        fun getMark(position: Int): Int
        fun getBoardSize(): Int
    }

    interface Model {
        fun markCross(position: Int)
        fun getMark(position: Int): Int
        fun getBoardSize(): Int
    }

    companion object Injector {
        fun inject(view: View) {
            val model = GameModel()
            val presenter = GamePresenter()

            view.injectPresenter(presenter)
            model.presenter = presenter
            presenter.view = view
            presenter.model = model
        }
    }
}
