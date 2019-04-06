package io.artrev.teoria.numbers.ints

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment
import java.util.Random
import java.util.stream.Collectors

/**
 * @see io.teoria.junit.numbers.Above
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class AboveSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val above: Above = sig.getAnnotation(Above::class.java)
        return Random().ints(above.limit.toLong(),
                if (above.inclusive)
                    above.value - 1
                else
                    above.value,
                Int.MAX_VALUE)
                .boxed()
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
                .collect(Collectors.toList())
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "ints"
    }
}
