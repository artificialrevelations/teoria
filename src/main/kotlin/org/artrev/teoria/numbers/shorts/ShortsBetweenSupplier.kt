package org.artrev.teoria.numbers.shorts

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment

/**
 * @see org.artrev.teoria.numbers.shorts.ShortsBetween
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class ShortsBetweenSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val annotation: ShortsBetween = sig.getAnnotation(ShortsBetween::class.java)

        return (annotation.first..annotation.last)
                .map { PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it.toShort()) }
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "shorts_between"
    }
}
