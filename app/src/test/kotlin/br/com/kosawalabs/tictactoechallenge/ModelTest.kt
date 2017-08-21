package br.com.kosawalabs.tictactoechallenge

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import kotlin.test.assertEquals

class ModelTest {

    lateinit var model: Contract.Model

    lateinit var mockPresenter: Contract.Presenter

    @Before
    fun setup() {
        val model = GameModel()
        val presenter = Mockito.mock(Contract.Presenter::class.java)

        model.presenter = presenter

        this.model = model
        mockPresenter = presenter
    }

    @Test
    @Throws(Exception::class)
    fun givenStartIsCalledItShouldCallStartGame() {
        val mockedPos = 1
        model.markCross(mockedPos)

        assertEquals(model.getMark(mockedPos), GameModel.POSITION_CROSS)
    }

}

