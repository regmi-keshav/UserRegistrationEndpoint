package com.example.UserRegistrationEndpoint.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "User Registration Endpoint",
                description =  "Implemented a user registration and user details fetch endpoints for a RESTful API using Spring Boot.",
                summary = "Implemented a user registration and user details fetch endpoints for a RESTful API using Spring Boot.",
                termsOfService = "T & C",
                contact = @Contact(
                        name = "Keshav Regmi",
                        email = "keshavregmi70@gmail.com"
                ),

                version = "v1"
        )
)
public class OpenApiConfig {
}
