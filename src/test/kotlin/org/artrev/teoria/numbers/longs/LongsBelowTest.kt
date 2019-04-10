package org.artrev.teoria.numbers.longs

import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class LongsBelowTest {
    @Theory
    fun `all passed values are below`(@LongsBelow(value = 42L) param: Long) {
        assertTrue(param < 42L)
    }
}