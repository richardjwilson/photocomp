package com.mistraltech.photocomp.model;

import com.mistraltech.smog.core.annotation.Matches;
import org.hamcrest.Matcher;

import static com.mistraltech.smog.proxy.javassist.JavassistMatcherGenerator.matcherOf;

@Matches(value = CompetitionConfig.class, description = "a CompetitionConfig")
public interface CompetitionConfigMatcher extends Matcher<CompetitionConfig> {
    static CompetitionConfigMatcher aCompetitionConfigThat() {
        return matcherOf(CompetitionConfigMatcher.class);
    }

    static CompetitionConfigMatcher aCompetitionConfigLike(final CompetitionConfig template) {
        return matcherOf(CompetitionConfigMatcher.class).like(template);
    }

    CompetitionConfigMatcher like(final CompetitionConfig template);

    CompetitionConfigMatcher hasAdministratorName(final PersonName administratorName);

    CompetitionConfigMatcher hasAdministratorName(final Matcher<? super PersonName> administratorNameMatcher);

    CompetitionConfigMatcher hasCompetitionName(final String competitionName);

    CompetitionConfigMatcher hasCompetitionName(final Matcher<? super String> competitionNameMatcher);
}
