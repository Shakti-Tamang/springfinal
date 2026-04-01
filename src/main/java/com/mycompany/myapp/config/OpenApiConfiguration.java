package com.mycompany.myapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.config.JHipsterProperties;

/**
 * OpenAPI configuration for Swagger UI.
 * Enables documentation of all REST API endpoints.
 */
@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI(JHipsterProperties jHipsterProperties) {
        Contact contact = new Contact();
        contact.setName(jHipsterProperties.getApiDocs().getContactName());
        contact.setUrl(jHipsterProperties.getApiDocs().getContactUrl());
        contact.setEmail(jHipsterProperties.getApiDocs().getContactEmail());

        License license = new License()
            .name(jHipsterProperties.getApiDocs().getLicense())
            .url(jHipsterProperties.getApiDocs().getLicenseUrl());

        Info info = new Info()
            .title(jHipsterProperties.getApiDocs().getTitle())
            .description(jHipsterProperties.getApiDocs().getDescription())
            .version(jHipsterProperties.getApiDocs().getVersion())
            .contact(contact)
            .license(license);

        if (jHipsterProperties.getApiDocs().getTermsOfServiceUrl() != null) {
            info.termsOfService(jHipsterProperties.getApiDocs().getTermsOfServiceUrl());
        }

        OpenAPI openAPI = new OpenAPI()
            .info(info)
            .addServersItem(new Server().url("http://localhost:8080").description("Development Server"))
            .addServersItem(new Server().url("https://localhost:8080").description("Development Server (HTTPS)"));

        // Add security scheme for Bearer token if needed
        SecurityScheme securityScheme = new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")
            .description("JWT Authorization header using the Bearer scheme");

        openAPI.schemaRequirement("bearer", securityScheme);

        return openAPI;
    }

    /**
     * Group REST API endpoints under a custom group in Swagger UI.
     */
    @Bean
    public GroupedOpenApi restApi() {
        return GroupedOpenApi
            .builder()
            .group("REST API")
            .displayName("REST API")
            .pathsToMatch("/api/**")
            .packagesToScan("com.mycompany.myapp.web.rest")
            .build();
    }
}

