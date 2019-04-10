package org.artrev.teoria.numbers.ints

import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class IntsBelowTest {
    @Theory
    fun `all passed values are below`(@IntsBelow(value = 42) param: Int) {
        assertTrue(param < 42)
    }
}