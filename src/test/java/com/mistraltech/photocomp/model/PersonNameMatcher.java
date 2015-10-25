package com.mistraltech.photocomp.model;

import com.mistraltech.smog.core.annotation.Matches;
import org.hamcrest.Matcher;

import java.util.Optional;

import static com.mistraltech.smog.proxy.javassist.JavassistMatcherGenerator.matcherOf;

@Matches(value = com.mistraltech.photocomp.model.PersonName.class, description = "a PersonName")
public interface PersonNameMatcher extends Matcher<PersonName> {
    static PersonNameMatcher aPersonNameThat() {
        return matcherOf(PersonNameMatcher.class);
    }

    static PersonNameMatcher aPersonNameLike(final PersonName template) {
        return matcherOf(PersonNameMatcher.class).like(template);
    }

    PersonNameMatcher like(final PersonName template);

    PersonNameMatcher hasForename(final String forename);

    PersonNameMatcher hasForename(final Matcher<? super String> forenameMatcher);

    PersonNameMatcher hasSurname(final Optional<String> surname);

    PersonNameMatcher hasSurname(final Matcher<? super Optional<String>> surnameMatcher);

    PersonNameMatcher hasTitle(final Optional<String> title);

    PersonNameMatcher hasTitle(final Matcher<? super Optional<String>> titleMatcher);
}
