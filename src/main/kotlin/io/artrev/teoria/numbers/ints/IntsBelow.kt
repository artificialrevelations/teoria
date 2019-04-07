package io.artrev.teoria.numbers.ints

import org.junit.experimental.theories.ParametersSuppliedBy

/**
 * Annotating a [Theory] method int parameter with &#064;IntsBelow causes it to be
 * supplied with values ending on the specified int value given when run as
 * a theory by the [Theories] runner.
 *
 * It is possible to specify if the supplied values should include the given
 * threshold and how many values should be generated, by default a 1000 values
 * will be created.
 *
 * For example, the below method would be called three times by the Theories
 * runner, once with each of the generated int values smaller then the specified.
 *
 * ```
 * @Theory
 * fun shouldPassForSomeInts(@IntsBelow(value = 42, limit = 3) param: Int) {
 *     ...
 * }
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(IntsBelowSupplier::class)
annotation class IntsBelow(
        val value: Int,
        val inclusive: Boolean = false,
        val limit: Int = 1000
)
