package org.artrev.teoria.numbers.doubles

import org.junit.experimental.theories.ParametersSuppliedBy

/**
 * Annotating a [Theory] method double parameter with &#064;DoublesBetween
 * causes it to be supplied with values between the specified double values
 * given when run as a theory by the [Theories] runner.
 *
 * For example, the below method would be called for all the values between the
 * specified first and last value by the Theories runner, once with each of the
 * generated double values larger then the specified.
 *
 * ```
 * @Theory
 * fun shouldPassForSomeDoubles(@IntsBetween(first = 1.0, last = 3.0) param: Double) {
 *     ...
 * }
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(DoublesBetweenSupplier::class)
annotation class DoublesBetween(
        val first: Double,
        val last: Double,
        val step: Double = 0.1
)
