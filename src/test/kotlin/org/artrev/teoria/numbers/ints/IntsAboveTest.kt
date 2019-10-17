package org.artrev.teoria.numbers.ints

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import kotlin.test.assertNotEquals

@RunWith(Theories::class)
class IntsAboveTest {
    @Theory
    fun `all passed values are above 42`(@IntsAbove(value = 42) param: Int) {
        assertTrue(param > 42)
    }

    @Theory
    fun `all passed values are not below 42`(@IntsAbove(value = 42) param: Int) {
        assertFalse(param < 42)
    }

    @Theory
    fun `generated value is never equal to 42`(@IntsAbove(value = 42) param: Int) {
        assertNotEquals(42, param)
    }
}