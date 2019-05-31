package org.artrev.teoria.numbers.shorts

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment
import kotlin.random.Random

/**
 * @see org.artrev.teoria.numbers.shorts.ShortsBelow
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class ShortsBelowSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val below: ShortsBelow = sig.getAnnotation(ShortsBelow::class.java)

        val from = Short.MIN_VALUE.toInt()
        val until = if (below.inclusive)
            below.value + 1
        else
            below.value.toInt()

        return generateSequence { Random.nextInt(from, until).toShort() }
                .distinct()
                .take(below.limit)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
                .toList()
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "shorts_below"
    }
}
