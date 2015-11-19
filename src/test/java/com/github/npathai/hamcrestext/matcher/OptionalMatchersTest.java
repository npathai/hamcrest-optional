package com.github.npathai.hamcrestext.matcher;

import static com.github.npathai.hamcrestext.matcher.OptionalMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class OptionalMatchersTest {

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
	public void testHasValue_Object_ShouldReturnAMatcher_WhichFailsIfOptionalIsEmpty() {
		exception.expect(AssertionError.class);
		exception.expectMessage("was <Empty>");

		Optional<String> optional = Optional.empty();
		assertThat(optional, hasValue("dummy value"));
	}

	@Test
	public void testHasValue_Object_ShouldReturnAMatcher_WhichSucceedsIfOptionalContainsValueEqualToOperand() {
		Optional<String> optional = Optional.of("dummy value");
		assertThat(optional, hasValue("dummy value"));
	}

	@Test
	public void testHasValue_Object_ShouldReturnAMatcher_WhichFailsIfOptionalContainsValueNotEqualToOperand() {
		exception.expect(AssertionError.class);
		exception.expectMessage("was <Present> and");
		exception.expectMessage("was \"dummy value\"");

		Optional<String> optional = Optional.of("dummy value");
		assertThat(optional, hasValue("another value"));
	}
	
	@Test
	public void testHasValue_Matcher_ShouldReturnAMatcher_WhichFailsIfOptionalIsEmpty() {
		exception.expect(AssertionError.class);
		exception.expectMessage("was <Empty>");
		
		Optional<String> hello = Optional.empty();
		assertThat(hello, hasValue(startsWith("a")));
	}
	
	@Test
	public void testHasValue_Matcher_ShouldReturnAMatcher_WhichSucceedsIfOptionalIsPresent_AndPassedMatcher_Succeeds() {
		Optional<String> hello = Optional.of("hello");
		assertThat(hello, hasValue(allOf(startsWith("h"), endsWith("o"))));
	}
	
	@Test
	public void testHasValue_Matcher_ShouldReturnAMatcher_WhichFailsIfOptionalIsPresent_ButPassedMatcher_Fails() {
		exception.expect(AssertionError.class);
		exception.expectMessage("was <Present> and");
		exception.expectMessage("was \"hello\"");
		
		Optional<String> hello = Optional.of("hello");
		assertThat(hello, hasValue(startsWith("a")));
	}
}
