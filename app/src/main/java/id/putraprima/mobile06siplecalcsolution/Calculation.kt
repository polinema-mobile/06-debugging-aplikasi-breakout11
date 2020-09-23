package id.putraprima.mobile06siplecalcsolution

import androidx.core.text.isDigitsOnly

object Calculation {
    fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun min(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    fun divide(num1: Int, num2: Int): Double {
        return (num1 / num2).toDouble()
    }

    fun multiply(num1: Int, num2: Int): Int {
        return num1 * num2
    }

    fun zeroInput(num1: Int, num2: Int): Boolean {
        return !(num1 == 0 || num2 == 0)
    }
}