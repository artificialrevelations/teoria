package org.artrev.teoria.numbers.shorts

import org.junit.experimental.theories.ParametersSuppliedBy

/**
 * Annotating a [Theory] method short parameter with &#064;ShortsBelow causes it
 * to be supplied with values ending on the specified short value given when run
 * as a theory by the [Theories] runner.
 *
 * It is possible to specify if the supplied values should include the given
 * threshold and how many values should be generated, by default a 1000 values
 * will be created.
 *
 * For example, the below method would be called three times by the Theories
 * runner, once with each of the generated short values smaller then the specified.
 *
 * ```
 * @Theory
 * fun shouldPassForSomeLongs(@ShortsBelow(value = 42, limit = 3) param: Short) {
 *     ...
 * }
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(ShortsBelowSupplier::class)
annotation class ShortsBelow(
        val value: Short,
        val inclusive: Boolean = false,
        val limit: Int = 1000
)
