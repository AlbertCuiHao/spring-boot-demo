package com.albert.common.swagger.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Albert
 */
@Configuration
public class SwaggerConfig {

    @Value("${albert.swagger.token_header}")
    private String tokenHeader;

    //swagger-ui/index.html
    @Bean
    public OpenAPI createOpenAPI() {
        OpenAPI openAPI = new OpenAPI();
        //添加header
        Map<String, SecurityScheme> map = new HashMap<>();
        map.put(tokenHeader, new SecurityScheme().type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.HEADER).name(tokenHeader));
        openAPI.components(new Components().securitySchemes(map));
        map.keySet().forEach(key -> openAPI.addSecurityItem(new SecurityRequirement().addList(key)));
        openAPI.info(new Info().title("SpringShop API")
                        .description("Spring shop sample application")
                        .version("0.0.1")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
        return openAPI;

    }
}
