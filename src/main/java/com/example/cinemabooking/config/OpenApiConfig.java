package com.example.cinemabooking.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cinema Booking API")
                        .version("1.0")
                        .description("Документация для Cinema Booking проекта")
                        .contact(new Contact()
                                .name("Nurmuhammed Sagyndyk")
                                .email("nsagyndyk006@gmail.com")
                        )
                );
    }
}
