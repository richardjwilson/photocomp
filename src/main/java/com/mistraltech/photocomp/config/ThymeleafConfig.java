package com.mistraltech.photocomp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
public class ThymeleafConfig {

  @Bean
  public TemplateResolver templateResolver() {
    TemplateResolver tr = new ServletContextTemplateResolver();

    tr.setPrefix("/WEB-INF/templates/");
    tr.setSuffix(".html");
    tr.setTemplateMode("HTML5");

    return tr;
  }

  @Bean
  public SpringTemplateEngine templateEngine() {
    SpringTemplateEngine te = new SpringTemplateEngine();

    te.setTemplateResolver(templateResolver());

    return te;
  }

  @Bean
  public ThymeleafViewResolver viewResolver() {
    ThymeleafViewResolver vr = new ThymeleafViewResolver();

    vr.setTemplateEngine(templateEngine());
    vr.setOrder(1);

    return vr;
  }
}
