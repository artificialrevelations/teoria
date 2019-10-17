package org.artrev.teoria.numbers.ints

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import kotlin.test.assertNotEquals

@RunWith(Theories::class)
class IntsBelowTest {
    @Theory
    fun `all passed values are below`(@IntsBelow(value = 42) param: Int) {
        assertTrue(param < 42)
    }

    @Theory
    fun `all passed values are not above 42`(@IntsBelow(value = 42) param: Int) {
        assertFalse(param > 42)
    }

    @Theory
    fun `generated value is never equal to 42`(@IntsBelow(value = 42) param: Int) {
        assertNotEquals(42, param)
    }
}