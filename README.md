# Hamcrest Optional
[![Travis CI build](https://travis-ci.org/npathai/hamcrest-optional.svg?branch=master)](https://travis-ci.org/npathai/hamcrest-optional)   [![Coverage Status](https://coveralls.io/repos/npathai/hamcrest-optional/badge.svg?branch=master&service=github)](https://coveralls.io/github/npathai/hamcrest-optional?branch=master)

An extension to [Java Hamcrest](https://github.com/hamcrest/JavaHamcrest) which provides matchers for *JDK 8* Optional

It provides matchers such as:

 - `isPresent()` - Matches if optional is present

 - `isEmpty()` - Matches if optional is empty

 - `hasValue(Matcher<T> m)` - Matches if optional contains a value that satisfies the specified matcher.

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

###`hasValue(Matcher<? super T> m)`

```java
Optional<String> optionalRef = someMethodReturningOptional();
assertThat(optionalRef, hasValue(startsWith("a"));
```

## Development Guide

hamcrest-optional is build with [Maven](http://maven.apache.org/). If you want
to contribute code then

* Please write a test for your change.
* Ensure that you don't break the build by running `mvn test`.
* Fork the repo and create a pull request. (See [Understanding the GitHub Flow](https://guides.github.com/introduction/flow/index.html))

hamcrest-optional supports [Travis CI](https://travis-ci.org/) for continuous
integration. Your pull request is automatically build by Travis CI.
