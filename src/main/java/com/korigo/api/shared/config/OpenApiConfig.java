package com.korigo.api.shared.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI korigoOpenApi() {
        return new OpenAPI()
            .info(new Info()
                .title("KoriGo API")
                .description("Documentation Swagger/OpenAPI des endpoints CRUD de la plateforme KoriGo.")
                .version("v1")
                .contact(new Contact()
                    .name("Equipe KoriGo")
                    .email("support@korigo.local"))
                .license(new License()
                    .name("Proprietary")
                    .url("https://korigo.local")));
    }
}
