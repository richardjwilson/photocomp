package com.mistraltech.photocomp.config;

import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import com.mistraltech.photocomp.repository.StubCompetitionConfigRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

    @Bean
    @Qualifier("stub")
    public CompetitionConfigRepository competitionConfigRepositoryStub() {
        return new StubCompetitionConfigRepository();
    }
}
