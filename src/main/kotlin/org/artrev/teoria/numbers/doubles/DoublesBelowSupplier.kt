package org.artrev.teoria.numbers.doubles

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment
import kotlin.random.Random

/**
 * @see org.artrev.teoria.numbers.doubles.DoublesBelow
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class DoublesBelowSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val below: DoublesBelow = sig.getAnnotation(DoublesBelow::class.java)

        val from = Double.MIN_VALUE
        val until = if (below.inclusive)
            below.value + below.epsilon
        else
            below.value

        return generateSequence { Random.nextDouble(from, until) }
                .distinct()
                .take(below.limit)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
                .toList()
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "doubles_below"
    }
}
