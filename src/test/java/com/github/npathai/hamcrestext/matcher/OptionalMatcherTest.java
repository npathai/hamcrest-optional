package com.github.npathai.hamcrestext.matcher;

import static com.github.npathai.hamcrestext.matcher.OptionalMatcher.isAbsent;
import static com.github.npathai.hamcrestext.matcher.OptionalMatcher.isPresent;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class OptionalMatcherTest {

	private static final Object ANY_VALUE = "value";

	@Rule public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testIsPresent_ShouldReturnAMatcher_WhichFailsIfOptionalIsEmpty() {
		exception.expect(AssertionError.class);
		
		Optional<Object> myOptionalRef = Optional.empty();
		
		assertThat(myOptionalRef, isPresent());
	}
	
	@Test
	public void testIsPresent_ShouldReturnAMatcher_WhichSucceedsIfOptionalIsPresent() {
		Optional<Object> myOptionalRef = Optional.of(ANY_VALUE);
		
		assertThat(myOptionalRef, isPresent());
	}
	
	@Test
	public void testIsAbsent_ShouldReturnAMatcher_WhichSucceedsIsOptionalIsAbsent() {
		assertThat(Optional.empty(), isAbsent());
	}
	
	@Test
	public void testIsAbsent_ShouldReturnAMatcher_WhichFailsIfOptionalIsPresent() {
		exception.expect(AssertionError.class);
		Optional<Object> myOptionalRef = Optional.of(ANY_VALUE);
		
		assertThat("An optional with some value should not be absent", myOptionalRef, isAbsent());
	}
}
