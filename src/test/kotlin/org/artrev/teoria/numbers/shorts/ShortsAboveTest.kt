package org.artrev.teoria.numbers.shorts

import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class ShortsAboveTest {
    @Theory
    fun `all passed values are above`(@ShortsAbove(value = 42) param: Short) {
        assertTrue(param > 42L)
    }
}