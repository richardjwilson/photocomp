package com.mistraltech.photocomp.controllers.competition.config.dto;

import com.mistraltech.photocomp.model.CompetitionConfig;
import com.mistraltech.photocomp.model.PersonName;
import org.junit.Test;

import java.util.Optional;

import static com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDtoMatcher.aCompetitionConfigDtoThat;
import static com.mistraltech.photocomp.model.CompetitionConfigMatcher.aCompetitionConfigThat;
import static com.mistraltech.photocomp.model.PersonNameMatcher.aPersonNameThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompetitionConfigDtoConverterTest {
    @Test
    public void canConvertToDto() {
        final CompetitionConfigDtoConverter competitionConfigDtoConverter = new CompetitionConfigDtoConverter();
        final PersonName administratorName = new PersonName(Optional.of("title"), "forename", Optional.of("surname"));
        final CompetitionConfig competitionConfig = new CompetitionConfig("comp", administratorName);

        final CompetitionConfigDto competitionConfigDto = competitionConfigDtoConverter.toDto(competitionConfig);

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoThat()
                .hasCompetitionName("comp")
                .hasAdminTitle("title")
                .hasAdminForename("forename")
                .hasAdminSurname("surname")));
    }

    @Test
    public void canConvertToDtoWithoutOptionalValues() {
        final CompetitionConfigDtoConverter competitionConfigDtoConverter = new CompetitionConfigDtoConverter();
        final PersonName administratorName = new PersonName(Optional.empty(), "forename", Optional.empty());
        final CompetitionConfig competitionConfig = new CompetitionConfig("comp", administratorName);

        final CompetitionConfigDto competitionConfigDto = competitionConfigDtoConverter.toDto(competitionConfig);

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoThat()
                .hasCompetitionName("comp")
                .hasAdminTitle(nullValue())
                .hasAdminForename("forename")
                .hasAdminSurname(nullValue())));
    }

    @Test
    public void canConvertToModel() {
        final CompetitionConfigDtoConverter competitionConfigDtoConverter = new CompetitionConfigDtoConverter();
        final CompetitionConfigDto dto = new CompetitionConfigDto();
        dto.setCompetitionName("comp");
        dto.setAdminTitle("title");
        dto.setAdminForename("forename");
        dto.setAdminSurname("surname");

        final CompetitionConfig competitionConfig = competitionConfigDtoConverter.toModel(dto);

        assertThat(competitionConfig, is(aCompetitionConfigThat()
                .hasCompetitionName("comp")
                .hasAdministratorName(aPersonNameThat()
                        .hasTitle(Optional.of("title"))
                        .hasForename("forename")
                        .hasSurname(Optional.of("surname")))));
    }

    @Test
    public void canConvertToModelWithoutOptionalValues() {
        final CompetitionConfigDtoConverter competitionConfigDtoConverter = new CompetitionConfigDtoConverter();
        final CompetitionConfigDto dto = new CompetitionConfigDto();
        dto.setCompetitionName("comp");
        dto.setAdminForename("forename");

        final CompetitionConfig competitionConfig = competitionConfigDtoConverter.toModel(dto);

        assertThat(competitionConfig, is(aCompetitionConfigThat()
                .hasCompetitionName("comp")
                .hasAdministratorName(aPersonNameThat()
                        .hasTitle(Optional.empty())
                        .hasForename("forename")
                        .hasSurname(Optional.empty()))));
    }
}
