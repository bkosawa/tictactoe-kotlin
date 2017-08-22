package br.com.kosawalabs.tictactoechallenge

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class PresenterTest {

    private val mockView: Contract.View = Mockito.mock(Contract.View::class.java)
    private val mockModel: Contract.Model = Mockito.mock(Contract.Model::class.java)
    private val presenter: Contract.Presenter = GamePresenter(mockView, mockModel)

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