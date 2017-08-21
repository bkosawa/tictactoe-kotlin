package br.com.kosawalabs.tictactoechallenge

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class PresenterTest {

    lateinit var presenter: Contract.Presenter
    lateinit var mockView: Contract.View
    lateinit var mockModel: Contract.Model

    @Before
    fun setup() {
        val presenter = GamePresenter()
        mockView = Mockito.mock(Contract.View::class.java)
        mockModel = Mockito.mock(Contract.Model::class.java)

        presenter.view = mockView
        presenter.model = mockModel
        this.presenter = presenter
    }

    @Test
    @Throws(Exception::class)
    fun givenStartIsCalledItShouldCallStartGame() {
        presenter.start()

        Mockito.verify(mockView).startGame()
    }

    @Test
    @Throws(Exception::class)
    fun givenOnClickedIsCalledItShouldCall() {
        val mockedPos = 1
        presenter.onClicked(mockedPos)

        Mockito.verify(mockModel).markCross(mockedPos)
    }
}