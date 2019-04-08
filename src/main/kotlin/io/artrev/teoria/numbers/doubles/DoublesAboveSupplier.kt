package io.artrev.teoria.numbers.doubles

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment
import kotlin.random.Random

/**
 * @see io.artrev.teoria.numbers.doubles.DoublesAbove
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class DoublesAboveSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val above: DoublesAbove = sig.getAnnotation(DoublesAbove::class.java)

        val from = if (above.inclusive)
            above.value - above.epsilon
        else
            above.value

        val until = Double.MAX_VALUE

        return generateSequence { Random.nextDouble(from, until) }
                .distinct()
                .take(above.limit)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
                .toList()
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "doubles_above"
    }
}
