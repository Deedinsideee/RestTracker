package com.example.resttracker.config;



import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/*@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)*/
public class OpenApiConfig {
    @Bean
    public OpenAPI cinemaProject()
    {
        return new OpenAPI()
                .info(new Info()
                        .title("Трекер задач")
                        .description("Rest трекер задач")
                        .version("0.1")
                        .license(new License().name("Apache 2.0"))
                        .contact(new Contact().name("Александр").email("kekicl@gmail.com"))




                );
    }



}
