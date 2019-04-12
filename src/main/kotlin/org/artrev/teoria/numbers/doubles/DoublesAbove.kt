package org.artrev.teoria.numbers.doubles

import org.junit.experimental.theories.ParametersSuppliedBy

/**
 * Annotating a [Theory] method double parameter with &#064;DoublesAbove causes
 * it to be supplied with values starting from the specified double value given
 * when run as a theory by the [Theories] runner.
 *
 * It is possible to specify if the supplied values should include the given
 * threshold and how many values should be generated, by default a 1000 values
 * will be created.
 *
 * For example, the below method would be called three times by the Theories
 * runner, once with each of the generated double values larger then the
 * specified.
 *
 * ```
 * @Theory
 * fun shouldPassForSomeDoubles(@DoublesAbove(value = 42.0, limit = 3) param: Double) {
 *     ...
 * }
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(DoublesAboveSupplier::class)
annotation class DoublesAbove(
        val value: Double,
        val epsilon: Double = 0.01,
        val inclusive: Boolean = false,
        val limit: Int = 1000
)
