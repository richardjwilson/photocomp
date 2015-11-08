package com.mistraltech.photocomp.config;

import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import com.mistraltech.photocomp.repository.DummyCompetitionConfigRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@ActiveProfiles({})
public class LiveRootConfigTest {

    @Autowired
    private CompetitionConfigRepository competitionConfigRepository;

    @Test
    public void ensureDummyCompetitionConfigRepositoryIsLoadedForNonStubProfile() {
        assertThat(competitionConfigRepository, is(instanceOf(DummyCompetitionConfigRepository.class)));
    }

}