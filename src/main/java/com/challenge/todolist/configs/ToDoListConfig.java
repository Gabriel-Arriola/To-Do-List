package com.challenge.todolist.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoListConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("TO-DO LIST API")
                        .description("To-Do List API REST")
                        .contact(new Contact()
                                .name("Gabriel Arriola")
                                .email("arriola.gabriel@gmail.com")
                                .url(null))
                        .version("1.0"));
    }
}
