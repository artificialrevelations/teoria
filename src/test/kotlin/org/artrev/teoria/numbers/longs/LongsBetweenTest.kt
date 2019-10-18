package org.artrev.teoria.numbers.longs

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class LongsBetweenTest {
    @Theory
    fun `all passed values are between`(@LongsBetween(first = 42L, last = 303L) param: Long) {
        assertTrue(param >= 42L || 303L <= param)
    }

    @Theory
    fun `all passed values are not below or above`(@LongsBetween(first = 42L, last = 303L) param: Long) {
        assertFalse(param < 42L || param > 303L)
    }
}