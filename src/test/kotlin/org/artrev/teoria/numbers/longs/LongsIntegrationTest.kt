package org.artrev.teoria.numbers.longs

import org.junit.Assert.assertTrue
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.experimental.theories.suppliers.TestedOn
import org.junit.runner.RunWith

@RunWith(Theories::class)
class LongsIntegrationTest {
    @Theory
    fun `first is lower then the second`(@LongsBelow(value = 42L) first: Long,
                                         @LongsAbove(value = 42L) second: Long) {
        assertTrue(first < second)
    }

    @Theory
    fun `first is larger then the second`(@LongsAbove(value = 42L) first: Long,
                                          @LongsBelow(value = 42L) second: Long) {
        assertTrue(first > second)
    }

    @Theory
    fun `all values of a range are lower then second`(@LongsBetween(first = 0L, last = 10L) range: Long,
                                                      @LongsAbove(value = 10L) second: Long) {
        assertTrue(range < second)
    }

    @Theory
    fun `first is lower then specified values`(@LongsBelow(value = 42L) first: Long,
                                               @TestedOn(ints = [100, 200, 300]) specified: Int) {
        assertTrue(first < specified)
    }

    @Theory
    fun `a times b should be larger then 0`(@LongsBetween(first = 1L, last = 3L) a: Long,
                                            @LongsBetween(first = 1L, last = 3L) b: Long) {
        // println("a = [$a], b = [$b]")
        assertTrue(a * b > 0)
    }
}