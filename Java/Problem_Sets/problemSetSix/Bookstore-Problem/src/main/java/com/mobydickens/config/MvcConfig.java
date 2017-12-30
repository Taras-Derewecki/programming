/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter
{

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/moby-dickens-login").setViewName("moby-dickens-login");
        registry.addViewController("/moby-dickens-logout-success").setViewName("moby-dickens-logout-success");
    }


}
