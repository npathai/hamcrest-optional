package com.github.npathai.hamcrestext.matcher;

import java.util.Optional;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public abstract class OptionalMatcher extends TypeSafeDiagnosingMatcher<Optional<?>> {

	public static Matcher<Optional<?>> isPresent() {
		return new PresenceMatcher();
	}

	private static class PresenceMatcher extends OptionalMatcher {
		
		public void describeTo(Description description) {
			
		}

		@Override
		protected boolean matchesSafely(Optional<?> item, Description mismatchDescription) {
			return item.isPresent();
		}
	}

	public static Matcher<Optional<?>> isAbsent() {
		return new AbsenceMatcher();
	}
	
	private static class AbsenceMatcher extends OptionalMatcher {

		public void describeTo(Description description) {
			
		}

		@Override
		protected boolean matchesSafely(Optional<?> item, Description mismatchDescription) {
			return !item.isPresent();
		}
		
	}
}
