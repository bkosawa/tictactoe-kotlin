package br.com.kosawalabs.tictactoechallenge

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class PresenterTest {

    lateinit var presenter: Contract.Presenter

    lateinit var mockView: Contract.View

    @Before
    fun setup() {
        val presenter = GamePresenter()
        mockView = Mockito.mock(Contract.View::class.java)

        presenter.view = mockView
        this.presenter = presenter
    }

    @Test
    @Throws(Exception::class)
    fun givenStartIsCalledItShouldCallStartGame() {
        presenter.start()

        Mockito.verify(mockView).startGame()
    }
}