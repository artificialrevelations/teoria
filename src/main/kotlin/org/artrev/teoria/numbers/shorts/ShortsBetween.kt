package org.artrev.teoria.numbers.shorts

import org.junit.experimental.theories.ParametersSuppliedBy

/**
 * Annotating a [Theory] method short parameter with &#064;LongsBetween causes it
 * to be supplied with values between the specified short values given when run as
 * a theory by the [Theories] runner.
 *
 * For example, the below method would be called for all the values between the
 * specified first and last value by the Theories runner, once with each of the
 * generated short values larger then the specified.
 *
 * ```
 * @Theory
 * fun shouldPassForSomeLongs(@ShortsBetween(first = 1, last = 3) param: Short) {
 *     ...
 * }
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(ShortsBetweenSupplier::class)
annotation class ShortsBetween(
        val first: Short,
        val last: Short
)
