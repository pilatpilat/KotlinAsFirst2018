package My

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled

class Tests {
    @Test
    @Tag("Aux")
    fun adder(){
        assertEquals(0, adder(-1, 1))
        assertEquals(10, adder(9, 1))
    }

    @Test
    @Tag("Aux")
    fun quadEquation() {
        assertEquals(listOf<Double>(), quadEquation(0.0, 0.0, 3.0))
        assertEquals(listOf<Double>(), quadEquation(3.0, -2.0, 1.0))
        assertArrayEquals(
                listOf<Double>(0.0).toDoubleArray(),
                quadEquation(1.0, 0.0, 0.0).toDoubleArray(),
                1e-5
        )
        assertArrayEquals(
                listOf<Double>(-1.23606, 3.23606).toDoubleArray(),
                quadEquation(2.0, -4.0, -8.0).toDoubleArray(),
                1e-5
        )
    }

    @Test
    @Tag("Aux")
    fun mySqrt(){
        assertEquals(listOf<Double>(), mySqrt(-1.0))
        assertArrayEquals(
                listOf<Double>(0.0).toDoubleArray(),
                mySqrt(0.0).toDoubleArray()
        )
        assertArrayEquals(
                listOf<Double>(-3.0, 3.0).toDoubleArray(),
                mySqrt(9.0).toDoubleArray()
        )
        assertEquals(
                listOf<Double>(-4.0, 4.0),
                mySqrt(16.0)
        )
    }
}
