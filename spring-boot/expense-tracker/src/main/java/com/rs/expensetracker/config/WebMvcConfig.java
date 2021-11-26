package com.rs.expensetracker.config;

import com.rs.expensetracker.misc.UserAuthorityEnumConverter;
import com.rs.expensetracker.misc.UserAuthorityEnumConverter2;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@EnableWebSecurity
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //converters.add(new UserAuthorityEnumConverter());
        WebMvcConfigurer.super.configureMessageConverters(converters);
        System.out.println("configureMessageConverters");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(new UserAuthorityEnumConverter2());
        WebMvcConfigurer.super.addFormatters(registry);
    }
}
