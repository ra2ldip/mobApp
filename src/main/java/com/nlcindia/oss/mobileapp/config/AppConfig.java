/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nlcindia.oss.mobileapp.config;

import java.io.IOException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author ratul
 */
@Configuration
@ComponentScan(basePackages = "com.nlcindia.oss.mobileapp", excludeFilters = {
    @ComponentScan.Filter(Configuration.class)})
@Import({DataConfig.class, MvcConfig.class})
// uncomment if required
//@ImportResource("classpath:tiles-defs.xml")
public class AppConfig {

    // uncomment if required
    //@Bean
    public PropertyPlaceholderConfigurer propertyConfigurer() throws IOException {
        PropertyPlaceholderConfigurer props = new PropertyPlaceholderConfigurer();
        props.setLocations(new Resource[]{new ClassPathResource("instance.properties")});
        return props;
    }

}
