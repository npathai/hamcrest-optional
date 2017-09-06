# Hamcrest Optional
[![Travis CI build](https://travis-ci.org/npathai/hamcrest-optional.svg?branch=master)](https://travis-ci.org/npathai/hamcrest-optional)   [![Coverage Status](https://coveralls.io/repos/npathai/hamcrest-optional/badge.svg?branch=master&service=github)](https://coveralls.io/github/npathai/hamcrest-optional?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.npathai/hamcrest-optional/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.npathai/hamcrest-optional)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg)](https://github.com/npathai/hamcrest-optional/blob/master/License.txt)

An extension to [Java Hamcrest](https://github.com/hamcrest/JavaHamcrest) which provides matchers for `java.util.Optional`.

## Maven Dependency
```
<dependencies>
...
<dependency>
  <groupId>com.github.npathai</groupId>
  <artifactId>hamcrest-optional</artifactId>
  <version>1.0</version>
</dependency>
...
</dependencies>
```

## Usage

hamcrest-optional provides four matchers for `Optional`: `isEmpty()`,
`isPresent()`, `isPresentAndIs(Object)` and `isPresentAnd(Matcher)`.

### isEmpty()

This matcher matches when the examined `Optional` contains no value.

```java
import static com.github.npathai.hamcrestopt.OptionalMatchers.isEmpty;

Optional<Object> optional = Optional.empty();
assertThat(optional, isEmpty());
```

### isPresent()

This matcher matches when the examined `Optional` contains a value.

```java
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresent;

Optional<String> optional = Optional.of("dummy value");
assertThat(optional, isPresent());
```

### isPresentAndIs(Object)

This matcher matches when the examined `Optional` contains a value that is
logically equal to the specified object.

```java
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAndIs;

Optional<String> optional = Optional.of("dummy value");
assertThat(optional, isPresentAndIs("dummy value"));
```

### isPresentAnd(Matcher)

This matcher matches when the examined `Optional` contains a value that
satisfies the specified matcher.

```java
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAnd;
import static org.hamcrest.Matchers.startsWith;

Optional<String> optional = Optional.of("dummy value");
assertThat(optional, isPresentAnd(startsWith("dummy")));
```

## Development Guide

hamcrest-optional is build with [Maven](http://maven.apache.org/). If you want
to contribute code then

* Please write a test for your change.
* Ensure that you don't break the build by running `mvn verify -Dgpg.skip`.
* Fork the repo and create a pull request. (See [Understanding the GitHub Flow](https://guides.github.com/introduction/flow/index.html))

hamcrest-optional supports [Travis CI](https://travis-ci.org/) for continuous
integration. Your pull request is automatically build by Travis CI.

## Release Guide

* Select a new version according to the
  [Semantic Versioning 2.0.0 Standard](http://semver.org/).
* Set the new version in `pom.xml`.
* Commit the modified `pom.xml`.
* Push the commit: `git push origin master`
* Run `mvn clean deploy` with JDK 8.
* Add a tag for the release: `git tag hamcrest-optional-X.X.X`
* Push the tag: `git push origin hamcrest-optional-X.X.X`
