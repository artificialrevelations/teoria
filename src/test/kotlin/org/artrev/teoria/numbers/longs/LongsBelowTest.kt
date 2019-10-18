package org.artrev.teoria.numbers.longs

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import kotlin.test.assertNotEquals

@RunWith(Theories::class)
class LongsBelowTest {
    @Theory
    fun `all passed values are below`(@LongsBelow(value = 42L) param: Long) {
        assertTrue(param < 42L)
    }

    @Theory
    fun `all passed values are not above 42`(@LongsBelow(value = 42L) param: Long) {
        assertFalse(param > 42L)
    }

    @Theory
    fun `generated value is never equal to 42`(@LongsBelow(value = 42L) param: Long) {
        assertNotEquals(42L, param)
    }
}