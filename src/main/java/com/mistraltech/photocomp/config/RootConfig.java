package com.mistraltech.photocomp.config;

import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import com.mistraltech.photocomp.repository.StubCompetitionConfigRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

    @Bean(name = "competitionConfigRepository")
    public CompetitionConfigRepository competitionConfigRepository() {
        return new StubCompetitionConfigRepository();
    }
}
