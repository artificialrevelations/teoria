package org.artrev.teoria.numbers.longs

import org.junit.experimental.theories.ParametersSuppliedBy

/**
 * Annotating a [Theory] method long parameter with &#064;LongsBetween causes it
 * to be supplied with values between the specified long values given when run as
 * a theory by the [Theories] runner.
 *
 * For example, the below method would be called for all the values between the
 * specified first and last value by the Theories runner, once with each of the
 * generated long values larger then the specified.
 *
 * ```
 * @Theory
 * fun shouldPassForSomeLongs(@LongsBetween(first = 1L, last = 3L) param: Long) {
 *     ...
 * }
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(LongsBetweenSupplier::class)
annotation class LongsBetween(
        val first: Long,
        val last: Long
)
