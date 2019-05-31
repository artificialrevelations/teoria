package org.artrev.teoria.numbers.longs

import org.junit.experimental.theories.ParametersSuppliedBy

/**
 * Annotating a [Theory] method long parameter with &#064;LongsBelow causes it to
 * be supplied with values ending on the specified longs value given when run as
 * a theory by the [Theories] runner.
 *
 * It is possible to specify if the supplied values should include the given
 * threshold and how many values should be generated, by default a 1000 values
 * will be created.
 *
 * For example, the below method would be called three times by the Theories
 * runner, once with each of the generated long values smaller then the specified.
 *
 * ```
 * @Theory
 * fun shouldPassForSomeLongs(@LongsBelow(value = 42L, limit = 3) param: Long) {
 *     ...
 * }
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(LongsBelowSupplier::class)
annotation class LongsBelow(
        val value: Long,
        val inclusive: Boolean = false,
        val limit: Int = 1000
)
