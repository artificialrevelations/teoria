package org.artrev.teoria.numbers.longs

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment
import kotlin.random.Random

/**
 * @see org.artrev.teoria.numbers.longs.LongsBelow
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class LongsBelowSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val below: LongsBelow = sig.getAnnotation(LongsBelow::class.java)

        val from = Long.MIN_VALUE
        val until = if (below.inclusive)
            below.value + 1L
        else
            below.value

        return generateSequence { Random.nextLong(from, until) }
                .distinct()
                .take(below.limit)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
                .toList()
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "longs_below"
    }
}
