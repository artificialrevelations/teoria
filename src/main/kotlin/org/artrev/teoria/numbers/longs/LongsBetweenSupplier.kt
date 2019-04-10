package org.artrev.teoria.numbers.longs

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment

/**
 * @see org.artrev.teoria.numbers.longs.LongsBetween
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class LongsBetweenSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val annotation: LongsBetween = sig.getAnnotation(LongsBetween::class.java)

        return (annotation.first..annotation.last)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it) }
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "longs_between"
    }
}
