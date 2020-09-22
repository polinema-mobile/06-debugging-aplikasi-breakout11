package id.putraprima.mobile06siplecalcsolution

import org.junit.Test
import org.junit.Assert.*

class MainActivityUnitTest {

    @Test
    fun add() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun min() {
        assertEquals(0, 2 - 2)
    }

    @Test
    fun divide() {
        assertEquals(2.5, 5.0 / 2.0, 3.0)
    }

    @Test
    fun multiply() {
        assertEquals(4, 2 * 2)
    }
}