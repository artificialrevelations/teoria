package org.artrev.teoria.numbers.doubles

import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.PotentialAssignment

/**
 * @see org.artrev.teoria.numbers.doubles.DoublesBetween
 * @see org.junit.experimental.theories.ParameterSupplier
 */
internal class DoublesBetweenSupplier : ParameterSupplier() {
    @Throws(Throwable::class)
    override fun getValueSources(sig: ParameterSignature): List<PotentialAssignment> {
        val between: DoublesBetween = sig.getAnnotation(DoublesBetween::class.java)

        return generateSequence(between.first) { it + between.step }
                .takeWhile {
                    it <= between.last
                }
                .map {
                    PotentialAssignment.forValue(ASSIGNMENT_VALUE_NAME, it)
                }
                .toList()
    }

    companion object {
        const val ASSIGNMENT_VALUE_NAME = "doubles_between"
    }
}
