package com.avinty.instantie.config;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.avinty.instantie.util.AuthHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    /**
     * Docket Bean Method
     * @return docket
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()))
                .operationOrdering(Comparator.comparingInt(Operation::getPosition))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    /**
     * ApiKey Bean Method
     * @return apikey
     */
    @Bean
    public ApiKey apiKey() {
        return new ApiKey(AuthHelper.SCHEME, AuthHelper.HEADER_NAME, AuthHelper.PASS_AS);
    }

    /**
     * MetaData Method
     * @return ApiInfo
     */
    public ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("INSTANTIE APPLICATION")
                .description("INSTANTIE APPLICATION REST API")
                .contact(new Contact("Mohamed Iqzas", "https://benestudio.co/", "mohamed.iqzas@benestudio.com"))
                .license("Commercial")
                .licenseUrl(null)
                .version("1.0.0")
                .build();
    }

    /**
     * Security Context Method
     * @return Security Context
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    /**
     * Default Auth Method
     * @return list of security reference
     */
    private List<SecurityReference> defaultAuth() {
        final AuthorizationScope authorizationScope =
                new AuthorizationScope("global", "accessEverything");
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
        return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
    }
}
