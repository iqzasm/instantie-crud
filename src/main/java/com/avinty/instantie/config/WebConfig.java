package com.avinty.instantie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Property Origins
     */
    @Value("${app.origins}")
    private String[] origins;

    /**
     * Cors Mapping Method
     * @param registry CorsRegistry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns(origins)
                .allowCredentials(Boolean.TRUE)
                .allowedMethods("POST", "GET", "PUT", "DELETE")
                .allowedHeaders(
                        "Access-Control-Allow-Headers",
                        "Access-Control-Expose-Headers",
                        "Access-Control-Allow-Origin",
                        "Access-Control-Request-Method",
                        "Access-Control-Request-Headers",
                        "Origin",
                        "Cache-Control",
                        "Content-Type",
                        "Authorization")
                .exposedHeaders("Authorization");
    }
}
