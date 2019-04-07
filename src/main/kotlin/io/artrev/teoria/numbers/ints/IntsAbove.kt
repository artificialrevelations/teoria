package io.artrev.teoria.numbers.ints

import org.junit.experimental.theories.ParametersSuppliedBy

/**
 * Annotating a [Theory] method int parameter with &#064;IntsAbove causes it to be
 * supplied with values starting from the specified int value given when run as
 * a theory by the [Theories] runner.
 *
 * It is possible to specify if the supplied values should include the given
 * threshold and how many values should be generated, by default a 1000 values
 * will be created.
 *
 * For example, the below method would be called three times by the Theories
 * runner, once with each of the generated int values larger then the specified.
 *
 * ```
 * @Theory
 * fun shouldPassForSomeInts(@IntsAbove(value = 42, limit = 3) param: Int) {
 *     ...
 * }
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(IntsAboveSupplier::class)
annotation class IntsAbove(
        val value: Int,
        val inclusive: Boolean = false,
        val limit: Int = 1000
)
