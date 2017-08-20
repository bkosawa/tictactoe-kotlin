package br.com.kosawalabs.tictactoechallenge

import android.util.Log

class GamePresenter : Contract.Presenter {
    lateinit var view: Contract.View

    override fun start() {
        view.startGame()
    }

    override fun onClicked(position: Int) {
        Log.d("Test", "Position: ${position}")
    }
}
