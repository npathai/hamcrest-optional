# hamcrest-jdk8-extras
An extension to ![Java Hamcrest](https://github.com/hamcrest/JavaHamcrest) which provides matchers for *JDK 8* Optional

It provides matchers such as:

 - `isPresent()` - Matches if optional is present

 - `isEmpty()` - Matches if optional is empty

 - `isPresentAnd(Matcher<T> m)` - Matches if optional is present and matches provided matcher.

##Usage
###`isPresent()`

```java
Optional<String> optionalRef = someMethodReturningOptional();
assertThat(optionalRef, isPresent());
```


###`isEmpty()`

```java
Optional<String> optionalRef = someMethodReturningOptional();
assertThat(optionalRef, isEmpty());
```

###`isPresentAnd(Matcher<? super T> m)`

```java
Optional<String> optionalRef = someMethodReturningOptional();
assertThat(optionalRef, isPresentAnd(startsWith("a"));
