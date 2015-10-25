package com.mistraltech.photocomp.controllers.competition.config;

import com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDto;
import com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDtoConverter;
import com.mistraltech.photocomp.model.CompetitionConfig;
import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(path = "/api/comp/config")
public class CompetitionConfigController {
    private Logger logger = LoggerFactory.getLogger(CompetitionConfigController.class);

    @Resource(name = "competitionConfigRepository")
    private CompetitionConfigRepository competitionConfigRepository;

    @Resource(name = "competitionConfigDtoConverter")
    private CompetitionConfigDtoConverter competitionConfigDtoConverter;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public
    CompetitionConfigDto getConfig() {
        logger.info("Processing get request for comp-config");

        CompetitionConfig storedCompetitionConfig = competitionConfigRepository.getConfig();

        return competitionConfigDtoConverter.toDto(storedCompetitionConfig);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public
    CompetitionConfigDto updateConfig(@RequestBody CompetitionConfigDto competitionConfigDto) {
        logger.info("Processing put request for comp-config");

        CompetitionConfig updatedCompetitionConfig = competitionConfigDtoConverter.toModel(competitionConfigDto);
        CompetitionConfig storedCompetitionConfig = competitionConfigRepository.save(updatedCompetitionConfig);

        return competitionConfigDtoConverter.toDto(storedCompetitionConfig);
    }
}
