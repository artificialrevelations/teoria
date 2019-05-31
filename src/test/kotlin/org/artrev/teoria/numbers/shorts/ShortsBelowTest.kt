package org.artrev.teoria.numbers.shorts

import org.junit.Assert
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class ShortsBelowTest {
    @Theory
    fun `all passed values are below`(@ShortsBelow(value = 42) param: Short) {
        Assert.assertTrue(param < 42L)
    }
}