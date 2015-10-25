package com.mistraltech.photocomp.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ThymeleafConfig.class, loader = AnnotationConfigContextLoader.class)
public class ThymeleafConfigTest {

    @Resource
    private TemplateResolver templateResolver;

    @Resource
    private TemplateEngine templateEngine;

    @Resource
    private ThymeleafViewResolver viewResolver;

    @Test
    public void testTemplateResolver() throws Exception {
        templateResolver.initialize();

        assertThat(templateResolver.getSuffix(), is(".html"));
        assertThat(templateResolver.getPrefix(), is("/WEB-INF/templates/"));
        assertThat(templateResolver.getTemplateMode(), is("HTML5"));
    }

    @Test
    public void testTemplateEngine() throws Exception {
        assertThat(templateEngine.getTemplateResolvers().size(), is(1));
        assertThat(templateEngine.getTemplateResolvers(), contains(templateResolver));
    }

    @Test
    public void testViewResolver() throws Exception {
        assertThat(viewResolver.getOrder(), is(1));
        assertThat(viewResolver.getTemplateEngine(), is(templateEngine));
    }
}
