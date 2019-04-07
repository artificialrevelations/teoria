package io.artrev.teoria.numbers.ints

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment
import kotlin.random.Random

/**
 * @see io.teoria.junit.numbers.Above
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class IntsAboveSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val above: IntsAbove = sig.getAnnotation(IntsAbove::class.java)

        val from = if (above.inclusive)
            above.value - 1
        else
            above.value

        val until = Int.MAX_VALUE

        return generateSequence { Random.nextInt(from, until) }
                .distinct()
                .take(above.limit)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
                .toList()
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "ints_above"
    }
}
