package test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CalculatorTest {
    @Test
    fun `when adding 1 and 2 expect 3`() {
        val result = Calculator.add(1, 2)
        assertEquals(4, result)
    }

    @Test
    fun `when adding 2 and 3 expect 5`() {
        val result = Calculator.add(2, 3)
        assertEquals(5, result)
    }
}