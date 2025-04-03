package com.example.springdatajpa.config;

import com.example.springdatajpa.utils.LoggerUtil;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean("logger")
    public Logger getLogger() {
        return LoggerUtil.getLogger();
    }
}
