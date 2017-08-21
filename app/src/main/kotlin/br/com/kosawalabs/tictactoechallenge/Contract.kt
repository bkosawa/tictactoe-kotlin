package br.com.kosawalabs.tictactoechallenge

class Contract {
    interface View {
        fun startGame()
    }

    interface Presenter {
        fun start()
        fun onClicked(position: Int)
    }

    interface Model {
        fun markCross(position: Int)
    }
}
