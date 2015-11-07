package com.mistraltech.photocomp.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WebConfigTest {

    @Mock
    private DefaultServletHandlerConfigurer mockConfigurer;

    @Test
    public void defaultServletHandlingIsEnabled() throws Exception {
        final WebConfig webConfig = new WebConfig();

        webConfig.configureDefaultServletHandling(mockConfigurer);

        verify(mockConfigurer).enable();
    }
}