package com.apirest.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info =
@Info(title = "Users API",
        version = "v1",
        description = "Users API with Unit Tests"))
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Users API")
                        .version("v1")
                        .description("Users API with Unit Tests")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .description("SpringShop Wiki Documentation"));
    }
}
