package com.github.npathai.hamcrestext.matcher;

import static com.github.npathai.hamcrestext.matcher.OptionalMatchers.*;
import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class OptionalMatchersTest {

	@Rule public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testIsPresent_ShouldReturnAMatcher_WhichFailsIfOptionalIsEmpty() {
		Optional<Object> myOptionalRef = Optional.empty();
		expectFailure(
				"Expected: is <Present>",
				"     but: was <Empty>");
		assertThat(myOptionalRef, isPresent());
	}
	
	@Test
	public void testIsPresent_ShouldReturnAMatcher_WhichSucceedsIfOptionalIsPresent() {
		Optional<Object> myOptionalRef = Optional.of("dummy value");
		
		assertThat(myOptionalRef, isPresent());
	}
	
	@Test
	public void testIsEmpty_ShouldReturnAMatcher_WhichSucceedsIsOptionalIsEmpty() {
		Optional<Object> myOptionalRef = Optional.empty();
		
		assertThat(myOptionalRef, isEmpty());
	}
	
	@Test
	public void testIsEmpty_ShouldReturnAMatcher_WhichFailsIfOptionalIsPresent() {
		Optional<Object> myOptionalRef = Optional.of("dummy value");
		expectFailure(
				"Expected: is <Empty>",
				"     but: had value \"dummy value\"");
		assertThat(myOptionalRef, isEmpty());
	}

	@Test
	public void testHasValue_Object_ShouldReturnAMatcher_WhichFailsIfOptionalIsEmpty() {
		Optional<String> optional = Optional.empty();
		expectFailure(
				"Expected: has value that is \"dummy value\"",
				"     but: was <Empty>");
		assertThat(optional, hasValue("dummy value"));
	}

	@Test
	public void testHasValue_Object_ShouldReturnAMatcher_WhichSucceedsIfOptionalContainsValueEqualToOperand() {
		Optional<String> optional = Optional.of("dummy value");
		assertThat(optional, hasValue("dummy value"));
	}

	@Test
	public void testHasValue_Object_ShouldReturnAMatcher_WhichFailsIfOptionalContainsValueNotEqualToOperand() {
		Optional<String> optional = Optional.of("dummy value");
		expectFailure(
				"Expected: has value that is \"another value\"",
				"     but: value was \"dummy value\"");
		assertThat(optional, hasValue("another value"));
	}
	
	@Test
	public void testHasValue_Matcher_ShouldReturnAMatcher_WhichFailsIfOptionalIsEmpty() {
		Optional<String> hello = Optional.empty();
		expectFailure(
				"Expected: has value that is a string starting with \"a\"",
				"     but: was <Empty>");
		assertThat(hello, hasValue(startsWith("a")));
	}
	
	@Test
	public void testHasValue_Matcher_ShouldReturnAMatcher_WhichSucceedsIfOptionalIsPresent_AndPassedMatcher_Succeeds() {
		Optional<String> hello = Optional.of("hello");
		assertThat(hello, hasValue(allOf(startsWith("h"), endsWith("o"))));
	}
	
	@Test
	public void testHasValue_Matcher_ShouldReturnAMatcher_WhichFailsIfOptionalIsPresent_ButPassedMatcher_Fails() {
		Optional<String> hello = Optional.of("hello");
		expectFailure(
				"Expected: has value that is a string starting with \"a\"",
				"     but: value was \"hello\"");
		assertThat(hello, hasValue(startsWith("a")));
	}

	private void expectFailure(String firstLineOfMessage, String secondLineOfMessage) {
		String expectedMessage = format("%n" + firstLineOfMessage + "%n" + secondLineOfMessage);
		exception.expect(AssertionError.class);
		exception.expectMessage(equalTo(expectedMessage));
	}
}
