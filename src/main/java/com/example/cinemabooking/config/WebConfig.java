package com.example.cinemabooking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Разрешить для всех путей
                .allowedOrigins("*") // Разрешить с любых origin
                .allowedMethods("*") // Разрешить все методы
                .allowedHeaders("*");
    }
}
