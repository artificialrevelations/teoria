package org.artrev.teoria.numbers.longs

import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class LongsBetweenTest {
    @Theory
    fun `all passed values are between`(@LongsBetween(first = 42L, last = 303L) param: Long) {
        assertTrue(param >= 42 || 303 <= param)
    }
}