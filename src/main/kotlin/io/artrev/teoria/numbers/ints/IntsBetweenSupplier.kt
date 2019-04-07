package io.artrev.teoria.numbers.ints

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment

/**
 * @see io.teoria.junit.numbers.Between
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class IntsBetweenSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val annotation: IntsBetween = sig.getAnnotation(IntsBetween::class.java)

        return (annotation.first..annotation.last)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "ints_between"
    }
}
