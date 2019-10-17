package org.artrev.teoria.numbers.ints

import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.experimental.theories.suppliers.TestedOn
import org.junit.runner.RunWith

@RunWith(Theories::class)
class IntsIntegrationTest {
    @Theory
    fun `first is lower then the second`(@IntsBelow(value = 42) first: Int,
                                         @IntsAbove(value = 42) second: Int) {
        assertTrue(first < second)
    }

    @Theory
    fun `first is larger then the second`(@IntsAbove(value = 42) first: Int,
                                          @IntsBelow(value = 42) second: Int) {
        assertTrue(first > second)
    }

    @Theory
    fun `all values of a range are lower then second`(@IntsBetween(first = 0, last = 10) range: Int,
                                                      @IntsAbove(value = 10) second: Int) {
        assertTrue(range < second)
    }

    @Theory
    fun `first is lower then specified values`(@IntsBelow(value = 42) first: Int,
                                               @TestedOn(ints = [100, 200, 300]) specified: Int) {
        assertTrue(first < specified)
    }

    @Theory
    fun `a times b should be larger then 0`(@IntsBetween(first = 1, last = 3) a: Int,
                                            @IntsBetween(first = 1, last = 3) b: Int) {
        // println("a = [$a], b = [$b]")
        assertTrue(a * b > 0)
    }
}