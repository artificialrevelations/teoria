package io.artrev.teoria.numbers.longs

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment
import kotlin.random.Random

/**
 * @see io.artrev.teoria.numbers.longs.LongsAbove
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class LongsAboveSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val above: LongsAbove = sig.getAnnotation(LongsAbove::class.java)

        val from = if (above.inclusive)
            above.value - 1L
        else
            above.value

        val until = Long.MAX_VALUE

        return generateSequence { Random.nextLong(from, until) }
                .distinct()
                .take(above.limit)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
                .toList()
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "longs_above"
    }
}
