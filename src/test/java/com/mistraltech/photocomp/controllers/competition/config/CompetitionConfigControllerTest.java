package com.mistraltech.photocomp.controllers.competition.config;

import com.mistraltech.photocomp.controllers.Converter;
import com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDto;
import com.mistraltech.photocomp.model.CompetitionConfig;
import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDtoBuilder.aCompetitionConfigDto;
import static com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDtoMatcher.aCompetitionConfigDtoThat;
import static com.mistraltech.photocomp.model.CompetitionConfigBuilder.aCompetitionConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class CompetitionConfigControllerTest {

    @Mock
    private CompetitionConfigRepository repository;

    @Mock
    private Converter<CompetitionConfig, CompetitionConfigDto> toDtoConverter;

    @Mock
    private Converter<CompetitionConfigDto, CompetitionConfig> toModelConverter;

    private CompetitionConfigController controllerUnderTest;

    @Before
    public void setUp() throws Exception {
        controllerUnderTest = new CompetitionConfigController(repository, toDtoConverter, toModelConverter);
    }

    @Test
    public void testGetConfig() throws Exception {
        final CompetitionConfig competitionConfig = aCompetitionConfig()
                .build();

        final CompetitionConfigDto competitionConfigDto = aCompetitionConfigDto()
                .withCompetitionName("CompName")
                .withAdminTitle("Title")
                .withAdminForename("Forename")
                .withAdminSurname("Surname")
                .build();

        when(repository.getConfig()).thenReturn(competitionConfig);
        when(toDtoConverter.convert(competitionConfig)).thenReturn(competitionConfigDto);

        MockMvc mockMvc = standaloneSetup(controllerUnderTest).build();

        mockMvc.perform(get("/api/comp/config"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{" +
                        "\"competitionName\":\"CompName\"," +
                        "\"adminTitle\":\"Title\"," +
                        "\"adminForename\":\"Forename\"," +
                        "\"adminSurname\":\"Surname\"" +
                        "}"));
    }

    @Test
    public void testUpdateConfig() throws Exception {
        final CompetitionConfig requestCompetitionConfig = aCompetitionConfig().build();
        final CompetitionConfig responseCompetitionConfig = aCompetitionConfig().build();

        when(toModelConverter.convert(argThat(is(aCompetitionConfigDtoThat()
                .hasCompetitionName("newCompName")
                .hasAdminTitle("newAdminTitle")
                .hasAdminForename("newAdminForename")
                .hasAdminSurname("newAdminSurname")))))
                .thenReturn(requestCompetitionConfig);

        when(repository.save(requestCompetitionConfig)).thenReturn(responseCompetitionConfig);

        when(toDtoConverter.convert(responseCompetitionConfig)).thenReturn(aCompetitionConfigDto()
                .withCompetitionName("CompName")
                .withAdminTitle("Title")
                .withAdminForename("Forename")
                .withAdminSurname("Surname")
                .build());

        MockMvc mockMvc = standaloneSetup(controllerUnderTest).build();

        mockMvc.perform(put("/api/comp/config")
                .content("{" +
                        "\"competitionName\": \"newCompName\"," +
                        "\"adminTitle\": \"newAdminTitle\"," +
                        "\"adminForename\": \"newAdminForename\"," +
                        "\"adminSurname\": \"newAdminSurname\"" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{" +
                        "\"competitionName\":\"CompName\"," +
                        "\"adminTitle\":\"Title\"," +
                        "\"adminForename\":\"Forename\"," +
                        "\"adminSurname\":\"Surname\"" +
                        "}"));
    }
}