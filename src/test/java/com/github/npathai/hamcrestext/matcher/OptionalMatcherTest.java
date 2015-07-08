package com.github.npathai.hamcrestext.matcher;

import static com.github.npathai.hamcrestext.matcher.OptionalMatcher.isEmpty;
import static com.github.npathai.hamcrestext.matcher.OptionalMatcher.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
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
		exception.expectMessage("Expected: <Present>");
		exception.expectMessage("was <Empty>");
		
		Optional<Object> myOptionalRef = Optional.empty();
		
		assertThat(myOptionalRef, isPresent());
	}
	
	@Test
	public void testIsPresent_ShouldReturnAMatcher_WhichSucceedsIfOptionalIsPresent() {
		Optional<Object> myOptionalRef = Optional.of(ANY_VALUE);
		
		assertThat(myOptionalRef, isPresent());
	}
	
	@Test
	public void testIsEmpty_ShouldReturnAMatcher_WhichSucceedsIsOptionalIsEmpty() {
		Optional<Object> myOptionalRef = Optional.empty();
		
		assertThat(myOptionalRef, isEmpty());
	}
	
	@Test
	public void testIsEmpty_ShouldReturnAMatcher_WhichFailsIfOptionalIsPresent() {
		exception.expect(AssertionError.class);
		exception.expectMessage("Expected: <Empty>");
		exception.expectMessage("was <Present> with value " + ANY_VALUE);
		
		Optional<Object> myOptionalRef = Optional.of(ANY_VALUE);
		
		assertThat("An optional with some value should not be empty", myOptionalRef, isEmpty());
	}
	
	@Test
	public void testIsPresentAnd_ShouldReturnAMatcher_WhichFailsIfOptionalIsEmpty() {
		exception.expect(AssertionError.class);
		exception.expectMessage("was <Empty>");
		
		Optional<String> hello = Optional.empty();
		assertThat(hello, isPresentAnd(startsWith("a")));
	}
	
	@Test
	public void testIsPresentAnd_ShouldReturnAMatcher_WhichSucceedsIfOptionalIsPresent_AndPassedMatcher_Succeeds() {
		Optional<String> hello = Optional.of("hello");
		assertThat(hello, isPresentAnd(allOf(startsWith("h"), endsWith("o"))));
	}
	
	@Test
	public void testIsPresentAnd_ShouldReturnAMatcher_WhichFailsIfOptionalIsPresent_ButPassedMatcher_Fails() {
		exception.expect(AssertionError.class);
		exception.expectMessage("was <Present> and");
		exception.expectMessage("was \"hello\"");
		
		Optional<String> hello = Optional.of("hello");
		assertThat(hello, isPresentAnd(startsWith("a")));
	}
}
