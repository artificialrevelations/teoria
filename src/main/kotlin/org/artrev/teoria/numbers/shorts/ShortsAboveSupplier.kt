package org.artrev.teoria.numbers.shorts

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment
import kotlin.random.Random

/**
 * @see org.artrev.teoria.numbers.shorts.ShortsAbove
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class ShortsAboveSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val above: ShortsAbove = sig.getAnnotation(ShortsAbove::class.java)

        val from: Int = if (above.inclusive)
            above.value - 1
        else
            above.value.toInt()

        val until = Short.MAX_VALUE.toInt()

        return generateSequence { Random.nextInt(from, until).toShort() }
                .distinct()
                .take(above.limit)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
                .toList()
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "shorts_above"
    }
}
