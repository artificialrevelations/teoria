package io.teoria.junit.numbers

import org.junit.experimental.theories.ParametersSuppliedBy

@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(BelowSupplier::class)
annotation class Below(
        val value: Int,
        val inclusive: Boolean = false,
        val limit: Int = 1000
)
