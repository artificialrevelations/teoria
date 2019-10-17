package org.artrev.teoria.numbers.ints

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class IntsBetweenTest {
    @Theory
    fun `all passed values are between`(@IntsBetween(first = 42, last = 303) param: Int) {
        assertTrue(param >= 42 || 303 <= param)
    }

    @Theory
    fun `all passed values are not below or above`(@IntsBetween(first = 42, last = 303) param: Int) {
        assertFalse(param < 42 || param > 303)
    }
}