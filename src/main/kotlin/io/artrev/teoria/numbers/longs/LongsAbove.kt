package io.artrev.teoria.numbers.longs

import org.junit.experimental.theories.ParametersSuppliedBy

/**
 * Annotating a [Theory] method int parameter with &#064;LongsAbove causes it to
 * be supplied with values starting from the specified long value given when run
 * as a theory by the [Theories] runner.
 *
 * It is possible to specify if the supplied values should include the given
 * threshold and how many values should be generated, by default a 1000 values
 * will be created.
 *
 * For example, the below method would be called three times by the Theories
 * runner, once with each of the generated long values larger then the specified.
 *
 * ```
 * @Theory
 * fun shouldPassForSomeLongs(@LongsAbove(value = 42L, limit = 3) param: Long) {
 *     ...
 * }
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(LongsAboveSupplier::class)
annotation class LongsAbove(
        val value: Long,
        val inclusive: Boolean = false,
        val limit: Int = 1000
)
