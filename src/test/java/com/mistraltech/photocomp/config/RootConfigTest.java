package com.mistraltech.photocomp.config;

import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RootConfigTest {

    @Autowired
    private GenericApplicationContext context;

    @Autowired
    private CompetitionConfigRepository competitionConfigRepository;

    @Test
    public void canGetCompetitionConfigRepository() {
        assertThat(competitionConfigRepository, is(notNullValue()));
    }
}
