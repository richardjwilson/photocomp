package com.mistraltech.photocomp.controllers.competition.config.dto;

import com.mistraltech.photocomp.controllers.Converter;
import com.mistraltech.photocomp.model.CompetitionConfig;
import org.springframework.stereotype.Component;

@Component
public class CompetitionConfigToCompetitionConfigDtoConverter
        implements Converter<CompetitionConfig, CompetitionConfigDto> {

    @Override
    public CompetitionConfigDto convert(CompetitionConfig source) {
        final CompetitionConfigDto dto = new CompetitionConfigDto();

        dto.setCompetitionName(source.getCompetitionName());
        dto.setAdminTitle(source.getAdministratorName().getTitle().orElse(null));
        dto.setAdminForename(source.getAdministratorName().getForename());
        dto.setAdminSurname(source.getAdministratorName().getSurname().orElse(null));

        return dto;
    }
}
