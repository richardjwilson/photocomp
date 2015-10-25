package com.mistraltech.photocomp.controllers.competition.config.dto;

import com.mistraltech.smog.core.annotation.Matches;
import org.hamcrest.Matcher;

import static com.mistraltech.smog.proxy.javassist.JavassistMatcherGenerator.matcherOf;

@Matches(value = CompetitionConfigDto.class, description = "a CompetitionConfigDto")
public interface CompetitionConfigDtoMatcher extends Matcher<CompetitionConfigDto> {
    static CompetitionConfigDtoMatcher aCompetitionConfigDtoThat() {
        return matcherOf(CompetitionConfigDtoMatcher.class);
    }

    static CompetitionConfigDtoMatcher aCompetitionConfigDtoLike(final CompetitionConfigDto template) {
        return matcherOf(CompetitionConfigDtoMatcher.class).like(template);
    }

    CompetitionConfigDtoMatcher like(final CompetitionConfigDto template);

    CompetitionConfigDtoMatcher hasAdminForename(final String adminForename);

    CompetitionConfigDtoMatcher hasAdminForename(final Matcher<? super String> adminForenameMatcher);

    CompetitionConfigDtoMatcher hasCompetitionName(final String competitionName);

    CompetitionConfigDtoMatcher hasCompetitionName(final Matcher<? super String> competitionNameMatcher);

    CompetitionConfigDtoMatcher hasAdminTitle(final String adminTitle);

    CompetitionConfigDtoMatcher hasAdminTitle(final Matcher<? super String> adminTitleMatcher);

    CompetitionConfigDtoMatcher hasAdminSurname(final String adminSurname);

    CompetitionConfigDtoMatcher hasAdminSurname(final Matcher<? super String> adminSurnameMatcher);
}
