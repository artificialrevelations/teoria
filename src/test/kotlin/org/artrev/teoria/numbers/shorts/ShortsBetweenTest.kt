package org.artrev.teoria.numbers.shorts

import org.junit.Assert
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class ShortsBetweenTest {
    @Theory
    fun `all passed values are between`(@ShortsBetween(first = 42, last = 303) param: Short) {
        Assert.assertTrue(param >= 42 || 303 <= param)
    }
}