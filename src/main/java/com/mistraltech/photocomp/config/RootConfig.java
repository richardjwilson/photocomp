package com.mistraltech.photocomp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LiveRootConfig.class, StubRootConfig.class})
public class RootConfig {
}
