# teoria

A collection of paramter suppliers for JUnit 4 Theories runner. To learn more about the `Theories` runner of JUnit 4 experimental package please check the description on the [project page](https://github.com/junit-team/junit4/wiki/Theories).

### Prerequisites

You can use this library in conjunction with JUnit `4.12`. Currently the only available comfortable way to import the library is through the use of [JITPACK.io](https://jitpack.io/):

In your `build.gradle` file at the end of `repositories` section add this line:

```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add `teoria` to the list of your test dependencies:

```groovy
	dependencies {
	        testImplementation 'com.github.foobaz42:teoria:master-SNAPSHOT'
	}
```

### Using teoria

Teoria contains several suppliers for basic types:
- `IntsAbove`, `IntsBelow` and `IntsBetween`
- `LongsAbove`, `LongsBelow` and `LongsBetween`
- `DoublesAbove`, `DoublesBelow` and `DoublesBetween`

You can write a test using them like this:

```java
@RunWith(Theories.class)
public class FooTest {
    @Theory
    public void a_theory_about_values_that_are_above(@IntsAbove(value = 42) final Integer value) {
        // test ...
    }

    @Theory
    public void a_theory_about_values_that_are_below(@LongsBelow(value = 42L) final Long value) {
        // test ...
    }
    
    @Theory
    public void a_theory_about_values_that_are_between(@DoublesBetween(first = 1.0, last = 42.0) final Double value) {
        // test ...
    }
}
```
