package id.putraprima.mobile06siplecalcsolution

import org.junit.Test
import org.junit.Assert.*

class MainActivityUnitTest {
    val mainActivity = MainActivity()

    @Test
    fun add() {
        assertEquals(4, mainActivity.add(2, 2))
    }

    @Test
    fun min() {
        assertEquals(0, 2 - 2)
    }

    @Test
    fun divide() {
        assertEquals(3.33, mainActivity.divide(10, 3), 0.01)
    }

    @Test
    fun multiply() {
        assertEquals(4, 2 * 2)
    }
}