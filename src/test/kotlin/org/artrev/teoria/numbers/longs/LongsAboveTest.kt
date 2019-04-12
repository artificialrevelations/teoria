package org.artrev.teoria.numbers.longs

import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class LongsAboveTest {
    @Theory
    fun `all passed values are above`(@LongsAbove(value = 42L) param: Long) {
        assertTrue(param > 42L)
    }
}