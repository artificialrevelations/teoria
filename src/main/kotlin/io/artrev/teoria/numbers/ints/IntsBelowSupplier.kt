package io.artrev.teoria.numbers.ints

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment
import kotlin.random.Random

/**
 * @see io.artrev.teoria.numbers.ints.IntsBelow
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class IntsBelowSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val below: IntsBelow = sig.getAnnotation(IntsBelow::class.java)

        val from = Int.MIN_VALUE
        val until = if (below.inclusive)
            below.value + 1
        else
            below.value

        return generateSequence { Random.nextInt(from, until) }
                .distinct()
                .take(below.limit)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
                .toList()
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "ints_below"
    }
}
