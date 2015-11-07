package com.mistraltech.photocomp;

import com.mistraltech.photocomp.config.RootConfig;
import com.mistraltech.photocomp.config.WebConfig;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class WebAppInitializerTest {

    @Test
    @SuppressWarnings("unchecked")
    public void canGetRootConfigClasses() throws Exception {
        final Class<?>[] rootConfigClasses = new WebAppInitializer().getRootConfigClasses();

        assertThat(rootConfigClasses, is(arrayContainingInAnyOrder(RootConfig.class)));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void canGetServletConfigClasses() throws Exception {
        final Class<?>[] servletConfigClasses = new WebAppInitializer().getServletConfigClasses();

        assertThat(servletConfigClasses, is(arrayContainingInAnyOrder(WebConfig.class)));
    }

    @Test
    public void canGetServletMappings() throws Exception {
        final String[] servletMappings = new WebAppInitializer().getServletMappings();
        assertThat(servletMappings, is(arrayContainingInAnyOrder("/")));
    }
}