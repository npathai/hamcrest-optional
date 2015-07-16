# hamcrest-jdk8-extras
[![Travis CI build](https://travis-ci.org/npathai/hamcrest-jdk8-extras.svg?branch=master)](https://travis-ci.org/npathai/hamcrest-jdk8-extras)   [![Coverage Status](https://coveralls.io/repos/npathai/hamcrest-jdk8-extras/badge.svg?branch=master&service=github)](https://coveralls.io/github/npathai/hamcrest-jdk8-extras?branch=master)

An extension to [Java Hamcrest](https://github.com/hamcrest/JavaHamcrest) which provides matchers for *JDK 8* Optional

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
