package org.artrev.teoria.numbers

import org.artrev.teoria.numbers.doubles.DoublesAbove
import org.artrev.teoria.numbers.ints.IntsBetween
import org.artrev.teoria.numbers.longs.LongsAbove
import org.artrev.teoria.numbers.shorts.ShortsBelow
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import kotlin.test.assertTrue

// not an integration test in a strict sense
@RunWith(Theories::class)
class NumbersIntegrationTest {
    @Theory
    fun `any element of the given int range is smaller then`(@IntsBetween(first = 1, last = 3) int: Int,
                                                             @DoublesAbove(value = 3.1, limit = 4) double: Double) {
        println("int = [$int], double = [$double]")
        assertTrue(int < double)
    }

    @Theory
    fun `any given short is smaller then the given long`(@ShortsBelow(value = 1) short: Short,
                                                         @LongsAbove(value = 1) long: Long) {
        assertTrue(short < long)
    }
}