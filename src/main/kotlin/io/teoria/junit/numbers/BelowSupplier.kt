package io.teoria.junit.numbers

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment
import java.util.Random
import java.util.stream.Collectors

/**
 * @see io.teoria.junit.numbers.Below
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class BelowSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val below: Below = sig.getAnnotation(Below::class.java)
        return Random().ints(
                below.limit.toLong(),
                Integer.MIN_VALUE,
                if (below.inclusive)
                    below.value + 1
                else
                    below.value
        )
                .boxed()
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
                .collect(Collectors.toList())
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "ints"
    }
}
