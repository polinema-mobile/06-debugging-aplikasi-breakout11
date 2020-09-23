package id.putraprima.mobile06siplecalcsolution

import com.google.common.truth.Truth
import org.junit.Test
import org.junit.Assert.*

class MainActivityUnitTest {

    @Test
    fun `Testing ADDITION Feature`() {
        assertEquals(2, Calculation.add(1,1))
    }

    @Test
    fun `Testing SUBSTRACTION Feature`() {
        assertEquals(0, Calculation.min(1,1))
    }

    @Test
    fun `Testing DIVISON Feature`() {
        assertEquals(2.0, Calculation.divide(4,2), 0.1)
    }

    @Test
    fun `Testing MULTIPLICATION Feature`() {
        assertEquals(4, Calculation.multiply(2,2))
    }

    @Test
    fun `Testing Negative Result From ADDITION`(){
        assertEquals(-1, Calculation.add(2, -3))
    }

    @Test
    fun `0 Input`(){
        Truth.assertThat(Calculation.zeroInput(0, 1)).isFalse()
    }

    @Test
    fun `0 Input True`(){
        Truth.assertThat(Calculation.zeroInput(1,1)).isTrue()
    }
}