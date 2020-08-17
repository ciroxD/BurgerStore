package com.tastyburguers.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static io.swagger.models.auth.In.HEADER;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static java.util.Collections.singletonList;



import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tastyburguers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo())
                .securityContexts(singletonList(SecurityContext.builder()
                .securityReferences(
                    singletonList(SecurityReference.builder()
                        .reference("JWT")
                        .scopes(new AuthorizationScope[0])
                        .build()
                    )
                )
                .build())
        )
                .securitySchemes(singletonList(new ApiKey("JWT", AUTHORIZATION, HEADER.name())));
    }


    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Tasty Burguers",
                "Your burguer is here",
                "1.0.0",
                "Termos de serviço",
                new Contact("Ciro Souza", "www.cirosouza.com",
                        "ciro_eng@ymail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}