package br.com.kosawalabs.tictactoechallenge

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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
    fun givenMarkCrossIsCalledItShouldSetCrossToPosition() {
        val mockedPos = 1
        model.markCross(mockedPos)

        assertEquals(model.getMark(mockedPos), GameModel.POSITION_CROSS)
    }

    @Test
    @Throws(Exception::class)
    fun givenMarkCircleIsCalledItShouldSetCircleToPosition() {
        val mockedPos = 1
        model.markCircle(mockedPos)

        assertEquals(model.getMark(mockedPos), GameModel.POSITION_CIRCLE)
    }

    @Test
    @Throws(Exception::class)
    fun givenItShould() {
        model.markCircle(0)
        model.markCircle(1)
        model.markCircle(2)
        assertTrue((model as GameModel).hasWonTheGame(GameModel.POSITION_CIRCLE))
    }

}

