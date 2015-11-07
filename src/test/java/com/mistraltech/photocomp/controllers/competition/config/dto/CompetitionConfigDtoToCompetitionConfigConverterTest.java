package com.mistraltech.photocomp.controllers.competition.config.dto;

import com.mistraltech.photocomp.model.CompetitionConfig;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static com.mistraltech.photocomp.model.CompetitionConfigMatcher.aCompetitionConfigThat;
import static com.mistraltech.photocomp.model.PersonNameMatcher.aPersonNameThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompetitionConfigDtoToCompetitionConfigConverterTest {

    private CompetitionConfigDtoToCompetitionConfigConverter converter;

    @Before
    public void setUp() {
        converter = new CompetitionConfigDtoToCompetitionConfigConverter();
    }

    @Test
    public void canConvertToModel() {
        final CompetitionConfigDto dto = new CompetitionConfigDto();
        dto.setCompetitionName("comp");
        dto.setAdminTitle("title");
        dto.setAdminForename("forename");
        dto.setAdminSurname("surname");

        final CompetitionConfig competitionConfig = converter.convert(dto);

        assertThat(competitionConfig, is(aCompetitionConfigThat()
                .hasCompetitionName("comp")
                .hasAdministratorName(aPersonNameThat()
                        .hasTitle(Optional.of("title"))
                        .hasForename("forename")
                        .hasSurname(Optional.of("surname")))));
    }

    @Test
    public void canConvertToModelWithoutOptionalValues() {
        final CompetitionConfigDto dto = new CompetitionConfigDto();
        dto.setCompetitionName("comp");
        dto.setAdminForename("forename");

        final CompetitionConfig competitionConfig = converter.convert(dto);

        assertThat(competitionConfig, is(aCompetitionConfigThat()
                .hasCompetitionName("comp")
                .hasAdministratorName(aPersonNameThat()
                        .hasTitle(Optional.empty())
                        .hasForename("forename")
                        .hasSurname(Optional.empty()))));
    }
}
