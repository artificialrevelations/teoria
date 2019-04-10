package org.artrev.teoria.numbers.ints

import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class IntsAboveTest {
    @Theory
    fun `all passed values are above`(@IntsAbove(value = 42) param: Int) {
        assertTrue(param > 42)
    }
}